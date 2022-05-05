package uk.co.santander.partyidv.omni.baas.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequiredArgsConstructor
public class EIDSteps {

    @And("check the status of customer is {string}")
    public void checkTheStatusOfCustomerIs(String arg0) {
    }

    @When("check_id is EID \\(L{int})")
    public void check_idIsEIDL(int arg0) {
    }

    @And("address details of customer are sent in request")
    public void addressDetailsOfCustomerAreSentInRequest(DataTable dataTable) {
    }

    @And("internal info values are sent in request")
    public void internalInfoValuesAreSentInRequest(DataTable dataTable) {
    }

    @Then("response returned is {string} and customerCompliantByEid as S with fields returned")
    public void responseReturnedIsAndCustomerCompliantByEidAsSWithFieldsReturned(String arg0, DataTable dataTable) {
    }

    @And("verify the status response with GET API")
    public void verifyTheStatusResponseWithGETAPI() {
    }

    @Then("response returned is {string} customerCompliantByEid as {string} with fields returned")
    public void responseReturnedIsCustomerCompliantByEidAsWithFieldsReturned(String arg0, String arg1, DataTable dataTable) {
    }



    @Then("response returned is http code 400 Bad request with error message")
    public void responseReturnedIsHttpCodeBadRequestWithErrorMessagePendingErrorMessage(String errMessage) {
    }

    @And("address details of customer are sent in request with parameters <premise>")
    public void addressDetailsOfCustomerAreSentInRequestWithParametersPremise() {
    }

    @Given("Call EID endpoint with valid session token")
    public void callEIDEndpointWithValidSessionToken() {
    }

    @Then("{int} http code is returned with message {string}")
    public void httpCodeIsReturnedWithMessage(int arg0, String arg1) {
    }

    @Given("Call EID endpoint without session token")
    public void callEIDEndpointWithoutSessionToken() {
    }

    @Given("Call EID endpoint with invalid session token")
    public void callEIDEndpointWithInvalidSessionToken() {
    }

    @Given("Call EID endpoint with expired session token")
    public void callEIDEndpointWithExpiredSessionToken() {
    }

    @Given("Call EID endpoint with not allowed method")
    public void callEIDEndpointWithNotAllowedMethod() {
    }

    @Given("Call EID endpoint with wrong URL")
    public void callEIDEndpointWithWrongURL() {
    }

    @Given("Call EID endpoint with token from different user")
    public void callEIDEndpointWithTokenFromDifferentUser() {
    }

    @When("POST EID endpoint with personal info parameter")
    public void postEIDEndpointWithPersonalInfoParameter(String param) {
    }

    @When("POST EID endpoint with personal info parameters")
    public void postEIDEndpointWithPersonalInfoParametersTitle(String dataTable) {
    }

    @When("POST EID endpoint with personal info with following parameters")
    public void postEIDEndpointWithPersonalInfoWithFollowingParameters(DataTable dataTable) {
    }
}
