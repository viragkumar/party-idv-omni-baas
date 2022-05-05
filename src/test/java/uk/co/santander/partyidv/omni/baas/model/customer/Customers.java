package uk.co.santander.partyidv.omni.baas.model.customer;

public class Customers {
    public static Customer HAPPY_PATH_CUSTOMER =
        Customer.builder()
            .aboutYouDetails(AboutYouDetailsData.HAPPY_PATH_ABOUT_YOU)
            .contactDetails(ContactDetailsData.HAPPY_PATH_CONTACT_DETAILS)
            .employmentDetails(EmploymentDetailsData.HAPPY_PATH_EMPLOYMENT_DETAILS)
            .yourAccountDetails(YourAccountDetailsData.HAPPY_PATH_YOUR_ACCOUNT_DETAILS)
            .build();

    public static Customer SELF_EMPLOYED_CUSTOMER =
        Customer.builder()
            .aboutYouDetails(AboutYouDetailsData.HAPPY_PATH_ABOUT_YOU)
            .contactDetails(ContactDetailsData.HAPPY_PATH_CONTACT_DETAILS)
            .employmentDetails(EmploymentDetailsData.SELF_EMPLOYED_DETAILS)
            .yourAccountDetails(YourAccountDetailsData.HAPPY_PATH_YOUR_ACCOUNT_DETAILS_OTHER_TYPE)
            .build();

    public static Customer HOMEMAKER_CUSTOMER =
        Customer.builder()
            .aboutYouDetails(AboutYouDetailsData.HAPPY_PATH_ABOUT_YOU)
            .contactDetails(ContactDetailsData.HAPPY_PATH_CONTACT_DETAILS)
            .employmentDetails(EmploymentDetailsData.HOMEMAKER_DETAILS)
            .yourAccountDetails(YourAccountDetailsData.HAPPY_PATH_YOUR_ACCOUNT_DETAILS_WITH_SWITCH_SAVINGS_ACCOUNT)
            .build();

    public static Customer LESS_THAN_THREE_YEAR_MOVED_IN_CUSTOMER =
        Customer.builder()
            .aboutYouDetails(AboutYouDetailsData.COUNTRY_OF_OTHER_TAX_RESIDENCY)
            .contactDetails(ContactDetailsData.LIVING_LESS_THAN_THREE_YEAR_CONTACT_DETAILS)
            .employmentDetails(EmploymentDetailsData.HOMEMAKER_DETAILS)
            .yourAccountDetails(YourAccountDetailsData.HAPPY_PATH_YOUR_ACCOUNT_DETAILS_WITH_SWITCH_SAVINGS_ACCOUNT)
            .build();
}
