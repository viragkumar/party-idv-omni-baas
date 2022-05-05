package uk.co.santander.partyidv.omni.baas.model.customer;

public class AboutYouDetailsData {
    public static final AboutYouDetails HAPPY_PATH_ABOUT_YOU =
        AboutYouDetails.builder()
            .title("MR")
            .firstName("Baron")
            .lastName("Cooper")
            .knownByOtherName(false)
            .isOtherNameMaidenName(false)
            .gender("male")
            .dateOfBirth("01/01/1990")
            .nationality("British")
            .countryOfBirth("United Kingdom")
            .isEligibleForTaxInOtherCountry(false)
            .build();

    public static final AboutYouDetails COUNTRY_OF_OTHER_TAX_RESIDENCY =
        AboutYouDetails.builder()
            .title("MR")
            .firstName("Hector")
            .lastName("Cooper")
            .knownByOtherName(false)
            .isOtherNameMaidenName(false)
            .gender("male")
            .dateOfBirth("01/01/1990")
            .nationality("British")
            .countryOfBirth("United Kingdom")
            .isEligibleForTaxInOtherCountry(true)
            .countryOfResidence("Albania")
            .taxIdentificationNumber("97112X123")
            .build();
}
