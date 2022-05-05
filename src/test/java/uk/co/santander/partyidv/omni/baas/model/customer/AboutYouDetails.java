package uk.co.santander.partyidv.omni.baas.model.customer;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class AboutYouDetails {
    String title;
    String firstName;
    String middleName;
    String lastName;
    String otherName;
    boolean knownByOtherName;
    boolean isOtherNameMaidenName;
    String gender;
    String dateOfBirth;
    String nationality;
    String countryOfBirth;
    boolean isEligibleForTaxInOtherCountry;
    String countryOfResidence;
    String taxIdentificationNumber;
}
