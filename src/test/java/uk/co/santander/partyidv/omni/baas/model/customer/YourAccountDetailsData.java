package uk.co.santander.partyidv.omni.baas.model.customer;

public class YourAccountDetailsData {
    public static final YourAccountDetails HAPPY_PATH_YOUR_ACCOUNT_DETAILS =
        YourAccountDetails.builder()
            .willYouBeMakingAnInitialDeposit(false)
            .doYouIntendToSwitch(false)
            .purposeOfNewAccount("Main bank account")
            .cashDepositEachMonth("£1,000 - £1,999")
            .build();


    public static final YourAccountDetails HAPPY_PATH_YOUR_ACCOUNT_DETAILS_WITH_SWITCH =
        YourAccountDetails.builder()
            .willYouBeMakingAnInitialDeposit(false)
            .doYouIntendToSwitch(true)
            .purposeOfNewAccount("Main bank account")
            .cashDepositEachMonth("£1,000 - £1,999")
            .build();


    public static final YourAccountDetails HAPPY_PATH_YOUR_ACCOUNT_DETAILS_WITH_SWITCH_SAVINGS_ACCOUNT =
        YourAccountDetails.builder()
            .willYouBeMakingAnInitialDeposit(false)
            .doYouIntendToSwitch(true)
            .purposeOfNewAccount("Savings")
            .payInEachMonth("5000")
            .monthlyOutgoings("3500")
            .cashDepositEachMonth("£2,000+")
            .moreThan2000SpecificAmount("3000")
            .build();


    public static final YourAccountDetails HAPPY_PATH_YOUR_ACCOUNT_DETAILS_OTHER_TYPE =
        YourAccountDetails.builder()
            .willYouBeMakingAnInitialDeposit(true)
            .sourceOfInitialDeposit("Retirement")
            .initialDepositAmount("1000")
            .doYouIntendToSwitch(false)
            .purposeOfNewAccount("Other")
            .whatWillYouUseTheAccountFor("The account would be used for Retirement savings")
            .payInEachMonth("5000")
            .monthlyOutgoings("3500")
            .cashDepositEachMonth("£2,000+")
            .moreThan2000SpecificAmount("5000")
            .isTheSourceFromTheUk(false)
            .whereIsItFrom("Spain")
            .build();
}
