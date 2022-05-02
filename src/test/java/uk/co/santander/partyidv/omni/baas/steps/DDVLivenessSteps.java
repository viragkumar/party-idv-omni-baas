package uk.co.santander.partyidv.omni.baas.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uk.co.santander.partyidv.omni.baas.config.ApplicationConfig;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;

//@CucumberContextConfiguration
@Slf4j
@RequiredArgsConstructor
public class DDVLivenessSteps {

    @Given("a customer is already onboarded")
    public void aCustomerIsAlreadyOnboarded() {
    }

    @When("check_id is ID&V \\(L{int})")
    public void check_idIsIDVL(int arg0) {
    }

    @And("Get the list of all valid documents for ID&V check")
    public void getTheListOfAllValidDocumentsForIDVCheck(DataTable table) {
    }

    @When("customer POST with Passport")
    public void customerPOSTWithPassport() {
    }

    @Then("get the session id in response")
    public void getTheSessionIdInResponse() {
    }

    @When("customer POST the session id and parameter dataMatch=True")
    public void customerPOSTTheSessionIdAndParameterDataMatchTrue() {
    }

    @And("get the response {string}")
    public void getTheResponse(String arg0) {
    }

    @Then("verify DDV status from ID&V DB with GET status API")
    public void verifyDDVStatusFromIDVDBWithGETStatusAPI() {
    }

    @When("customer POST with Driving License")
    public void customerPOSTWithDrivingLicense() {
    }

    @And("get the reponse {string}")
    public void getTheReponse(String arg0) {
    }

    @Then("verify ID&V status from DB with GET status API")
    public void verifyIDVStatusFromDBWithGETStatusAPI() {
    }

    @When("customer POST with Provisional driving license")
    public void customerPOSTWithProvisionalDrivingLicense() {
    }

    @When("customer POST with BRP card")
    public void customerPOSTWithBRPCard() {
    }

    @Then("response returned is http code {int} Bad request with error message {string}")
    public void responseReturnedIsHttpCodeBadRequestWithErrorMessage(int arg0, String arg1) {
    }
}
