package uk.co.santander.partyidv.omni.baas.client.sqs;

import com.amazonaws.services.sqs.model.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.mail.util.MimeMessageParser;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import uk.co.santander.partyidv.omni.baas.model.RawMailMessage;
import uk.co.santander.partyidv.omni.baas.model.UnwrappedSqsMessage;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

import static org.awaitility.Awaitility.await;

@Service
@Slf4j
@RequiredArgsConstructor
public class SessionTokenService {

    private final SqsService sqsService;
    private final ObjectMapper objectMapper;
    private final SqsProperties sqsProperties;

    private static final int MAX_NUMBER_OF_QUEUE_POLLS = 5;
    private static final int QUEUE_POLL_INTERVAL_SECONDS = 3;


    public Optional<String> getSessionTokenForEmail(final String emailAddress) throws Exception {
        final String queueUrl = sqsProperties.getQueueUrl();
        List<UnwrappedSqsMessage> matchingMessages = Collections.emptyList();

        for (int i = 0; i < MAX_NUMBER_OF_QUEUE_POLLS; i++) {
            final List<Message> messagesFromQueue = sqsService.getMessagesFromQueue(queueUrl).getMessages();
            final List<UnwrappedSqsMessage> unwrappedMessages = unwrapMessages(messagesFromQueue);
            matchingMessages = getMessagesForRecipientEmailAddress(emailAddress, unwrappedMessages);

            if (matchingMessages.isEmpty()) {
                log.error("No message found with expected recipient {}, sleeping for {} seconds", emailAddress, QUEUE_POLL_INTERVAL_SECONDS);
                await().pollDelay(Duration.ofSeconds(QUEUE_POLL_INTERVAL_SECONDS)).timeout(Duration.ofSeconds(QUEUE_POLL_INTERVAL_SECONDS + 1)).until(() -> true);
            } else {
                break;
            }
        }

        final Optional<String> token = getJwtFromMessages(matchingMessages.stream().map(UnwrappedSqsMessage::getRawMailMessage).collect(Collectors.toList()));
        if (token.isPresent()) {
            log.info("Found token {} for email address {}", token.get(), emailAddress);
            matchingMessages.stream()
                .map(UnwrappedSqsMessage::getReceiptHandle)
                .forEach(message -> sqsService.deleteMessageFromQueue(message, queueUrl));
        } else {
            log.error("Did not find a token for email address {}", emailAddress);
        }

        return token;
    }

    private Optional<String> getJwtFromMessages(final List<RawMailMessage> matchingMessages) throws Exception {
        for (RawMailMessage message : matchingMessages) {
            var content = message.getContent();

            Properties sysProps = System.getProperties();
            Session mailSession = Session.getInstance(sysProps, null);
            MimeMessage mimeMessage = new MimeMessage(mailSession, new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8)));

            MimeMessageParser parser = new MimeMessageParser(mimeMessage);
            parser.parse();

            String htmlContent = parser.getHtmlContent();

            final Document document = Jsoup.parse(htmlContent);
            final Element link = document.select("a").first();

            return UriComponentsBuilder.fromUriString(link.attr("href")).build()
                .getQueryParams()
                .entrySet()
                .stream()
                .filter(param -> "token".equalsIgnoreCase(param.getKey()))
                .flatMap(p -> p.getValue().stream())
                .findFirst();
        }

        return Optional.empty();
    }

    private List<UnwrappedSqsMessage> getMessagesForRecipientEmailAddress(final String emailAddress, final List<UnwrappedSqsMessage> unwrappedMessages) {
        final List<UnwrappedSqsMessage> matchingMessages = new ArrayList<>();

        for (UnwrappedSqsMessage message : unwrappedMessages) {
            List<String> recipients = message.getRawMailMessage().getReceipt().getRecipients();
            log.info("Found message with recipients {}", recipients);
            if (recipients.contains(emailAddress)) {
                log.info("Found message with expected recipient {}", emailAddress);
                matchingMessages.add(message);
            }
        }

        return matchingMessages;
    }

    private List<UnwrappedSqsMessage> unwrapMessages(final List<Message> messagesFromQueue) throws JsonProcessingException, JSONException {
        final List<UnwrappedSqsMessage> matchingMessages = new ArrayList<>();

        for (Message m : messagesFromQueue) {
            RawMailMessage message = objectMapper.readValue(new JSONObject(m.getBody()).getString("Message"), RawMailMessage.class);
            matchingMessages.add(
                UnwrappedSqsMessage.builder()
                    .receiptHandle(m.getReceiptHandle())
                    .rawMailMessage(message)
                    .build()
            );
        }

        return matchingMessages;
    }
}
