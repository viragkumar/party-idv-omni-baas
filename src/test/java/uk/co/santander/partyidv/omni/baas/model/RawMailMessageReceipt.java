package uk.co.santander.partyidv.omni.baas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
@AllArgsConstructor
public class RawMailMessageReceipt {

    @JsonProperty("recipients")
    List<String> recipients;
}
