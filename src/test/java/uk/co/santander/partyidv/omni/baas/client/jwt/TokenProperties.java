package uk.co.santander.partyidv.omni.baas.client.jwt;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "sirius.api.token")
public class TokenProperties {

    private String channelKey;
}
