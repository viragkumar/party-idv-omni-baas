package uk.co.santander.partyidv.omni.baas.steps;

import com.google.inject.Inject;
import io.cucumber.java.en.Given;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import uk.co.santander.partyidv.omni.baas.model.customer.Customer;
import uk.co.santander.partyidv.omni.baas.state.CustomerState;
import uk.co.santander.partyidv.omni.baas.state.SharedState;
import uk.co.santander.partyidv.omni.baas.utils.RandomDataGeneratorUtils;

@Slf4j
@RequiredArgsConstructor(onConstructor_={@Inject})
public class RandomDataGeneratorSteps {
    @Inject
    private SharedState sharedState;

    @Given("generate dynamic profile for a new customer")
    public void generateDynamicProfileForANewCustomer() {
        RandomDataGeneratorUtils randomDataGeneratorSteps = new RandomDataGeneratorUtils();

        Customer customer = Customer.builder()
                .aboutYouDetails(randomDataGeneratorSteps.generateAboutYouRandom())
                .contactDetails(randomDataGeneratorSteps.generateContactDetailsRandom())
                .employmentDetails(randomDataGeneratorSteps.generateEmploymentDetailsRandom())
                .yourAccountDetails(randomDataGeneratorSteps.generateYourAccountDetailsRandom())
                .yourOverdraft(randomDataGeneratorSteps.generateYourOverdraftDetailsRandom())
                .build();


        log.info(customer.toString());
//        sharedState.setState(CustomerState.CUSTOMER, customer);
    }

}
