package uk.co.santander.partyidv.omni.baas.client.sqs;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
@EnableConfigurationProperties(SqsProperties.class)
public class SqsService {
    private final AmazonSQS sqs;
    private final SqsProperties sqsProperties;

    public ReceiveMessageResult getMessagesFromQueue(final String queueUrl) {
        final int visibilityTimeoutSeconds = sqsProperties.getVisibilityTimeoutSeconds();
        final int waitTimeSeconds = sqsProperties.getWaitTimeSeconds();
        final int maxNumberOfMessages = sqsProperties.getMaxNumberOfMessages();

        log.info("Polling for up to {} messages from queue {} for up to {} seconds", maxNumberOfMessages, queueUrl, waitTimeSeconds);
        ReceiveMessageResult receiveMessageResult = sqs.receiveMessage(new ReceiveMessageRequest()
                .withQueueUrl(queueUrl)
                .withVisibilityTimeout(visibilityTimeoutSeconds)
                .withWaitTimeSeconds(waitTimeSeconds)
                .withMaxNumberOfMessages(maxNumberOfMessages)
        );
        log.info("Found {} messages in queue {}", receiveMessageResult.getMessages().size(), queueUrl);
        return receiveMessageResult;
    }

    public void deleteMessageFromQueue(final String receiptHandle, final String queueUrl) {
        log.info("Deleting message with receipt handle {} from queue {}", receiptHandle, queueUrl);
        sqs.deleteMessage(new DeleteMessageRequest()
                .withQueueUrl(queueUrl)
                .withReceiptHandle(receiptHandle)
        );
    }
}
