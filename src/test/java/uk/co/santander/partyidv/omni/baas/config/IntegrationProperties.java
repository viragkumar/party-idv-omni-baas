package uk.co.santander.partyidv.omni.baas.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@AllArgsConstructor
@Getter
@ConfigurationProperties(prefix = "sirius.api.integrations")
public class IntegrationProperties {

    @NonNull
    private final String apiGatewayUrl;

    @NonNull
    private final boolean proxyEnabled;

    private final String proxyUsername;

    private final String proxyPassword;
}
