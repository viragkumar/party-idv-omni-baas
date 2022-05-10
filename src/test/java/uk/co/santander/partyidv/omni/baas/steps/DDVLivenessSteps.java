package uk.co.santander.partyidv.omni.baas.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java8.PendingException;
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
        throw new PendingException();
    }

    @When("check_id is ID&V \\(L{int})")
    public void check_idIsIDVL(int arg0) {
        throw new PendingException();
    }

    @And("Get the list of all valid documents for ID&V check")
    public void getTheListOfAllValidDocumentsForIDVCheck(DataTable table) {
        throw new PendingException();
    }

    @When("customer POST with Passport")
    public void customerPOSTWithPassport() {
        throw new PendingException();
    }

    @Then("get the session id in response")
    public void getTheSessionIdInResponse() {
        throw new PendingException();
    }

    @When("customer POST the session id and parameter dataMatch=True")
    public void customerPOSTTheSessionIdAndParameterDataMatchTrue() {
        throw new PendingException();
    }

    @And("get the response {string}")
    public void getTheResponse(String arg0) {
        throw new PendingException();
    }

    @Then("verify DDV status from ID&V DB with GET status API")
    public void verifyDDVStatusFromIDVDBWithGETStatusAPI() {
        throw new PendingException();
    }

    @When("customer POST with Driving License")
    public void customerPOSTWithDrivingLicense() {
        throw new PendingException();
    }

    @And("get the reponse {string}")
    public void getTheReponse(String arg0) {
        throw new PendingException();
    }

    @Then("verify ID&V status from DB with GET status API")
    public void verifyIDVStatusFromDBWithGETStatusAPI() {
        throw new PendingException();
    }

    @When("customer POST with Provisional driving license")
    public void customerPOSTWithProvisionalDrivingLicense() {
        throw new PendingException();
    }

    @When("customer POST with BRP card")
    public void customerPOSTWithBRPCard() {
        throw new PendingException();
    }

    @Then("response returned is http code {int} Bad request with error message {string}")
    public void responseReturnedIsHttpCodeBadRequestWithErrorMessage(int arg0, String arg1) {
        throw new PendingException();
    }

    @And("POST Start ID&V session with sending parameters documentType as Passport and include Liveness as True")
    public void postStartIDVSessionWithSendingParametersDocumentTypeAsPassportAndIncludeLivenessAsTrue() {

    }

    @Given("a customer has registered and customer id is created")
    public void aCustomerHasRegisteredAndCustomerIdIsCreated() {
        throw new PendingException();
    }

    @And("check if customer id exists in ID&V DB")
    public void checkIfCustomerIdExistsInIDVDB() {
        throw new PendingException();
    }

    @And("transform the {string} option from ID&V DB to DDV format  {string}")
    public void transformTheOptionFromIDVDBToDDVFormat(String arg0, String arg1) {
        throw new PendingException();
    }

    @And("session_id is created and returned in response")
    public void session_idIsCreatedAndReturnedInResponse() {
        throw new PendingException();
    }

    @And("POST complete ID&V session with dataMatch=True")
    public void postCompleteIDVSessionWithDataMatchTrue() {
        throw new PendingException();
    }

    @And("verify the DDV status is {string}")
    public void verifyTheDDVStatusIs(String arg0) {
        throw new PendingException();
    }

    @Then("verify the the check_id status is updated in ID&V DB")
    public void verifyTheTheCheck_idStatusIsUpdatedInIDVDB() {
        throw new PendingException();
    }
}
