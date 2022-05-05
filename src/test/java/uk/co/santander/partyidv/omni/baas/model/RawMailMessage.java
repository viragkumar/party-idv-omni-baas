package uk.co.santander.partyidv.omni.baas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class RawMailMessage {

    @JsonProperty("receipt")
    RawMailMessageReceipt receipt;

    @JsonProperty("content")
    String content;
}
