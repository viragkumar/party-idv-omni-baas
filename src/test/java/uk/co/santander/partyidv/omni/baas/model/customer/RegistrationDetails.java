package uk.co.santander.partyidv.omni.baas.model.customer;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class RegistrationDetails {
    String firstName;
    String emailAddress;
}
