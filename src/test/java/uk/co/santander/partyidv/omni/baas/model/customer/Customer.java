package uk.co.santander.partyidv.omni.baas.model.customer;

import lombok.Builder;
import lombok.ToString;
import lombok.Value;

@Builder
@Value
@ToString
public class Customer {
    private AboutYouDetails aboutYouDetails;
    private ContactDetails contactDetails;
    private EmploymentDetails employmentDetails;
    private YourAccountDetails yourAccountDetails;
    private YourOverdraft yourOverdraft;
}
