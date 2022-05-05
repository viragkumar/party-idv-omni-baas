package uk.co.santander.partyidv.omni.baas.model.Registration;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class RegistrationRequestAcceptedContentId {
    @JsonProperty("type")
    String type;

    @JsonProperty("key")
    String key;
}
