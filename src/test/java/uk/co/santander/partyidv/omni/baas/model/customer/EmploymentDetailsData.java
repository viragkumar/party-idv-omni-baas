package uk.co.santander.partyidv.omni.baas.model.customer;

public class EmploymentDetailsData {
    public static final EmploymentDetails HAPPY_PATH_EMPLOYMENT_DETAILS =
        EmploymentDetails.builder()
            .employmentStatus("Employed")
            .occupation("Traffic engineer")
            .dateStarted("11/11/2015")
            .employersName("Job")
            .controlOverCompany(false)
            .companySector("Public sector")
            .incomeSource("Employment or Benefits")
            .monthlyIncome("2100")
            .isTheIncomeForTheUk(true)
            .monthlyOutgoings("2000")
            .financialDependents("0")
            .build();

    public static final EmploymentDetails SELF_EMPLOYED_DETAILS =
        EmploymentDetails.builder()
            .employmentStatus("Self employed")
            .occupation("Doctor")
            .dateStarted("11/11/2015")
            .employersName("Hospital")
            .controlOverCompany(false)
            .industrySector("HOSPITAL ACTIVITIES")
            .incomeSource("Property")
            .monthlyIncome("5000")
            .isTheIncomeForTheUk(true)
            .monthlyOutgoings("500")
            .financialDependents("2")
            .build();

    public static final EmploymentDetails HOMEMAKER_DETAILS =
        EmploymentDetails.builder()
            .employmentStatus("Homemaker")
            .controlOverCompany(false)
            .incomeSource("Property")
            .monthlyIncome("5000")
            .isTheIncomeForTheUk(false)
            .whereIsItFrom("India")
            .monthlyOutgoings("500")
            .financialDependents("2")
            .build();
}
