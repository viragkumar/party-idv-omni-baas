package uk.co.santander.partyidv.omni.baas.model.customer;

public class ContactDetailsData {
    public static final ContactDetails HAPPY_PATH_CONTACT_DETAILS =
        ContactDetails.builder()
            .mobileNumber("7900000000")
            .postcode("LS11 9LX")
            .accommodationCircumstances("Living with parents")
            .howLongHaveYouLivedHere("More than 5 years ago")
            .build();

    public static final ContactDetails LIVING_LESS_THAN_THREE_YEAR_CONTACT_DETAILS =
        ContactDetails.builder()
            .mobileNumber("7900000000")
            .postcode("LS11 9LX")
            .accommodationCircumstances("Living with parents")
            .howLongHaveYouLivedHere("Less than 3 years ago")
            .whenDidYouMoveIn("03/2021")
            .flatName("miltonkyene")
            .houseName("23456")
            .streetName("Park street")
            .district("London")
            .town("london")
            .postcode1("mk9 1bb")
            .whenDidYouMoveIn1("12/2018")
            .build();
}
