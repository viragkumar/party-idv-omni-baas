package uk.co.santander.partyidv.omni.baas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Value;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "message",
        "errors"
})
@Value
public class ResponseException {
    @JsonProperty("message")
    String message;

    @JsonProperty("errors")
    List<Object> errors = null;

    @JsonIgnore
    Map<String, Object> additionalProperties = new HashMap<>();
}
