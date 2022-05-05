package uk.co.santander.partyidv.omni.baas.model.Registration;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class RegistrationRequestAttribution {
    @JsonProperty("channel_key")
    String channelKey;

    @JsonProperty("product_key")
    String productKey;
}
