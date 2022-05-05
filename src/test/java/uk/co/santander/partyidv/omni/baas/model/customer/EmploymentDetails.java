package uk.co.santander.partyidv.omni.baas.model.customer;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class EmploymentDetails {
    String employmentStatus;
    String occupation;
    String dateStarted;
    String employersName;
    boolean controlOverCompany;
    String industrySector;
    String companySector;
    String incomeSource;
    String monthlyIncome;
    boolean isTheIncomeForTheUk;
    String whereIsItFrom;
    String monthlyOutgoings;
    String financialDependents;
}
