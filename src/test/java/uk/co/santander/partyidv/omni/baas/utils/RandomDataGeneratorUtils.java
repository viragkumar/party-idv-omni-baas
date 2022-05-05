package uk.co.santander.partyidv.omni.baas.utils;

import com.github.javafaker.Faker;
import com.google.gson.internal.LinkedTreeMap;
import com.google.inject.Inject;
import com.lindar.postcodes.io.client.PostcodesClient;
import io.cucumber.java.en.Given;
import uk.co.santander.partyidv.omni.baas.model.customer.*;
import uk.co.santander.partyidv.omni.baas.state.SharedState;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class RandomDataGeneratorUtils {

    public YourOverdraft generateYourOverdraftDetailsRandom() {
        Faker faker = new Faker(Locale.UK, new Random(24));
        String amount = String.valueOf(faker.number().numberBetween(0, 40) * 50);
        YourOverdraft yourOverdraft =
                YourOverdraft.builder().amount(amount)
                        .build();

        return yourOverdraft;
    }


    public YourAccountDetails generateYourAccountDetailsRandom() {
        String[] cashDepositEachMonth = {"£0", "£1 - £1,000", "£1,000 - £1,999"};
        Faker faker = new Faker(Locale.UK);
        String accountPurpose = "Main bank account";

        YourAccountDetails yourAccountDetails =
                YourAccountDetails.builder()
                        .willYouBeMakingAnInitialDeposit(false)
                        .doYouIntendToSwitch(faker.bool().bool())
                        .purposeOfNewAccount(accountPurpose)
                        .cashDepositEachMonth(pickRandomElement(cashDepositEachMonth))
                        .build();

        return yourAccountDetails;
    }

    public EmploymentDetails generateEmploymentDetailsRandom() {
        String[] occupation = {"Paint consultant", "Painter", "Painter and decorator", "Figure painter", "Paint sprayer"};
        String[] incomeSource = {"Employment or Benefits", "Retirement", "Inheritance", "Property", "Stocks, Shares, Bonds, Managed Investments or Debentures", "Sale/Divestment of assets", "Legal Settlement", "Ownership/sale virtual currencies", "Gift", "Another person/entity", "Savings", "Student"};
        Faker faker = new Faker(Locale.UK);
        String companyStartDate = new SimpleDateFormat("dd/MM/yyyy")
                .format(pickRandomMoveinFiveYearsOlderdate(faker));

        EmploymentDetails employmentDetails = EmploymentDetails.builder()
                .employmentStatus("Employed")
                .occupation(pickRandomElement(occupation))
                .dateStarted(companyStartDate)
                .employersName(faker.company().name())
                .controlOverCompany(false)
                .companySector("Public sector")
                .incomeSource(pickRandomElement(incomeSource))
                .monthlyIncome(String.valueOf(faker.number().randomDouble(3,1000, 3000)))
                .isTheIncomeForTheUk(true)
                .monthlyOutgoings(String.valueOf(faker.number().randomDouble(3, 1000, 3000)))
                .financialDependents(String.valueOf(faker.number().numberBetween(0, 3)))
                .build();

        return employmentDetails;
    }

    public ContactDetails generateContactDetailsRandom() {
        String[] accomodationCircumstancesArray = {"Living with parents", "Living with friends/relatives", "Tenant", "Outright Owner", "Owner with mortgage", "Owner with Santander mortgage"};
        String[] howLongLived = {"Three to five years ago", "More than 5 years ago"};
        Faker faker = new Faker(Locale.UK);

        String moveInDate = new SimpleDateFormat("MM/yyyy")
                .format(pickRandomMoveinFiveYearsOlderdate(faker));

        ContactDetails contactDetails = ContactDetails.builder()
                .mobileNumber(pickRandomMobile())
                .postcode(pickRandomPostCode())
                .accommodationCircumstances(pickRandomElement(accomodationCircumstancesArray))
                .howLongHaveYouLivedHere(pickRandomElement(howLongLived))
                .whenDidYouMoveIn(moveInDate)
                .flatName(faker.address().buildingNumber())
                .houseName(faker.address().streetAddressNumber())
                .streetName(faker.address().streetName())
                .district(faker.address().city())
                .town(faker.address().city())
                .build();

        return contactDetails;
    }

    public AboutYouDetails generateAboutYouRandom() {
        String[] titles = {"Mr", "Mrs", "Miss", "Ms", "Mx"};
        String[] gender = {"Male", "Female"};
        String[] nationality = {"British", "Afgani", "Algerian", "Indian", "Brazilian", "Canadian", "Spanish", "Swiss", "Russian", "Yemenite"};

        Faker faker = new Faker(Locale.ENGLISH);

        AboutYouDetails RANDOM_ABOUT_YOU =
                AboutYouDetails.builder()
                        .title(pickRandomElement(titles))
                        .firstName(faker.name().firstName())
                        .middleName(faker.app().name())
                        .lastName(faker.name().lastName())
                        .knownByOtherName(false)
                        .isOtherNameMaidenName(false)
                        .gender(pickRandomElement(gender))
                        .dateOfBirth(pickRandomBirthdate(faker))
                        .nationality(pickRandomElement(nationality))
                        .countryOfBirth(faker.address().country())
                        .isEligibleForTaxInOtherCountry(false)
                        .taxIdentificationNumber(faker.app().name())
                        .build();

        return RANDOM_ABOUT_YOU;

    }

    private String pickRandomPostCode() {
        //Get Random UK Postcode
        PostcodesClient instance = new PostcodesClient();
        Object ResponsePostcodeData = instance.randomPostcode().getData();
        LinkedTreeMap ResponsePostcodeMap = (LinkedTreeMap) ResponsePostcodeData;
        return (String) ResponsePostcodeMap.get("postcode");
    }

    private String pickRandomMobile() {
        long LOWER_MOBILE_LIMIT = 7120000000L;
        long UPPER_MOBILE_LIMIT = 7129999999L;
        long mobileNumber = LOWER_MOBILE_LIMIT + (long) (Math.random() * (UPPER_MOBILE_LIMIT - LOWER_MOBILE_LIMIT));
        return String.valueOf(mobileNumber);
    }

    private Date pickRandomMoveinFiveYearsOlderdate(Faker faker) {
        int MIN_AGE = 5;
        int MAX_AGE = 10;
        int YEAR_DAYS = 365;
        String pattern = "MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, -MIN_AGE);

        return faker.date().past(MAX_AGE * YEAR_DAYS, TimeUnit.DAYS, c.getTime());
    }

    private String pickRandomBirthdate(Faker faker) {
        int MIN_AGE = 18;
        int MAX_AGE = 120;
        int YEAR_DAYS = 365;
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, -MIN_AGE);

        return simpleDateFormat.format(faker.date().past(MAX_AGE * YEAR_DAYS, TimeUnit.DAYS, c.getTime()));
    }

    private String pickRandomElement(String[] arr) {
        return Arrays.stream(arr).findAny().get();
    }
}
