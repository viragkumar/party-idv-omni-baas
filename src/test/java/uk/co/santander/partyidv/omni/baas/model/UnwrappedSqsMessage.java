package uk.co.santander.partyidv.omni.baas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class UnwrappedSqsMessage {

    String receiptHandle;

    RawMailMessage rawMailMessage;
}
