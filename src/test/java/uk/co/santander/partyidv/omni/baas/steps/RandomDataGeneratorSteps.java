package uk.co.santander.partyidv.omni.baas.steps;

import com.google.inject.Inject;
import io.cucumber.java.en.Given;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.RecursiveToStringStyle;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import uk.co.santander.partyidv.omni.baas.model.customer.Customer;
import uk.co.santander.partyidv.omni.baas.model.customer.EmploymentDetailsData;
import uk.co.santander.partyidv.omni.baas.model.customer.YourAccountDetailsData;
import uk.co.santander.partyidv.omni.baas.state.CustomerState;
import uk.co.santander.partyidv.omni.baas.state.SharedState;
import uk.co.santander.partyidv.omni.baas.utils.RandomDataGeneratorUtils;

@Slf4j
@RequiredArgsConstructor
public class RandomDataGeneratorSteps {
    @Inject
    private SharedState sharedState;


    @Given("generate dynamic profile for a new customer")
    public void generateDynamicProfileForANewCustomer() {
        RandomDataGeneratorUtils randomDataGeneratorSteps = new RandomDataGeneratorUtils();
        Customer customer = Customer.builder()
                .aboutYouDetails(randomDataGeneratorSteps.generateAboutYouRandom())
                .contactDetails(randomDataGeneratorSteps.generateContactDetailsRandom())
                .employmentDetails(EmploymentDetailsData.HAPPY_PATH_EMPLOYMENT_DETAILS)
                .yourAccountDetails(YourAccountDetailsData.HAPPY_PATH_YOUR_ACCOUNT_DETAILS)
                .build();

        System.out.println("****Customer (random)****: " +
                ReflectionToStringBuilder.toString(customer, new RecursiveToStringStyle()));
    }
}
