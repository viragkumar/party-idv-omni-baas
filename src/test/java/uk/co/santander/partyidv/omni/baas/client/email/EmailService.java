package uk.co.santander.partyidv.omni.baas.client.email;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
@EnableConfigurationProperties(EmailProperties.class)
public class EmailService {

        private final EmailProperties emailProperties;

        public String generateNewEmailAddress() {
    //        final String emailAddress = emailProperties.getUsername() + UUID.randomUUID() + "@" + emailProperties.getProvider();
            final String emailAddress = "TI-api-" + System.currentTimeMillis() + "@" + emailProperties.getProvider();
            log.info("Generated email address: {}", emailAddress);
            return emailAddress;
        }

}
