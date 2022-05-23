package uk.co.santander.partyidv.omni.baas.client.documentcontrol;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "sirius.api.documentcontrol")
public class DocumentControlProperties {

    private String apihost;
}
