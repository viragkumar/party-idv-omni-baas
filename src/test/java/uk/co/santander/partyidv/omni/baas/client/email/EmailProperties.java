package uk.co.santander.partyidv.omni.baas.client.email;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "sirius.api.email")
public class EmailProperties {

    private String username;
    private String provider;
}
