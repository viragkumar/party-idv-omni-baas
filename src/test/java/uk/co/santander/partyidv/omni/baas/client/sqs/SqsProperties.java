package uk.co.santander.partyidv.omni.baas.client.sqs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@AllArgsConstructor
@Getter
@ConfigurationProperties(prefix = "sirius.api.sqs")
public class SqsProperties {

    @NonNull
    private final String queueUrl;
    @NonNull
    private final Integer visibilityTimeoutSeconds;
    @NonNull
    private final Integer maxNumberOfMessages;
    @NonNull
    private final Integer waitTimeSeconds;
}
