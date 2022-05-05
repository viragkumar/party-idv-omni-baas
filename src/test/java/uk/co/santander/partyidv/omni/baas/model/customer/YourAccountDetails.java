package uk.co.santander.partyidv.omni.baas.model.customer;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class YourAccountDetails {
    boolean willYouBeMakingAnInitialDeposit;
    boolean doYouIntendToSwitch;
    String purposeOfNewAccount;
    String whatWillYouUseTheAccountFor;
    String payInEachMonth;
    String monthlyOutgoings;
    String cashDepositEachMonth;
    String moreThan2000SpecificAmount;
    String sourceOfInitialDeposit;
    String initialDepositAmount;
    boolean isTheSourceFromTheUk;
    String whereIsItFrom;
}
