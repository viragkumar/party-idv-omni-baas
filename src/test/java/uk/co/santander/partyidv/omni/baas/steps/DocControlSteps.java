package uk.co.santander.partyidv.omni.baas.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import uk.co.santander.partyidv.omni.baas.client.email.EmailService;
import uk.co.santander.partyidv.omni.baas.config.ApplicationConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import uk.co.santander.partyidv.omni.baas.config.IntegrationProperties;
import uk.co.santander.partyidv.omni.baas.model.Registration.RegistrationRequest;
import uk.co.santander.partyidv.omni.baas.model.Registration.RegistrationRequestAttribution;
import uk.co.santander.partyidv.omni.baas.restassured.HttpMethods;
import uk.co.santander.partyidv.omni.baas.utils.RandomDataGeneratorUtils;

@Slf4j
@RequiredArgsConstructor
public class DocControlSteps {
    @Autowired
    public EmailService emailServiceClient;

    @Autowired
    public HttpMethods httpMethods;
    private final ObjectMapper objectMapper;

    @Given("user is onboarding first time on PCA")
    public void userIsOnboardingFirstTimeOnPCA() throws Exception {
        String emailAddress = emailServiceClient.generateNewEmailAddress();

        // Call API to generate session id
        final RegistrationRequest registrationRequest = RegistrationRequest.builder()
                .email(emailAddress)
                .attribution(RegistrationRequestAttribution.builder()
                        .channelKey("SANUK")
                        .productKey("PCA")
                        .build())

                .build();

        httpMethods.post("/v1/auth/users", objectMapper.writeValueAsString(registrationRequest)).then().statusCode(201);
    }

    @And("GET the status of customer")
    public void getTheStatusOfCustomer() {
    }

    @Then("status is returned as {int}\\(new)")
    public void statusIsReturnedAsNew(int arg0) {
    }

    @And("he goes through identity check \\(L{int})")
    public void heGoesThroughIdentityCheckL(int arg0) {
    }

    @And("GET IdCheck_DocList API gets hit")
    public void getIdCheck_DocListAPIGetsHit() {
    }

    @Then("the list of documents is returned for user to upload")
    public void theListOfDocumentsIsReturnedForUserToUpload(DataTable dataTable) {
    }

    @Given("user is coming second time on PCA")
    public void userIsComingSecondTimeOnPCA() {
    }

    @Then("status is returned as {int}\\(in progress) and document used in ID check \\(L{int})")
    public void statusIsReturnedAsInProgressAndDocumentUsedInIDCheckL(int arg0, int arg1) {
    }

    @Then("he goes through residency check \\(L2)")
    public void heGoesThroughResidencyCheckL2() {
    }


    @Then("GET residency_Check_DocList API gets hit")
    public void getResidency_Check_DocListAPIGetsHit() {
    }

    @Then("he has used UK Driving Licence for ID check \\(L1)")
    public void heHasUsedUKDrivingLicenceForIDCheck_L1() {
    }

    @Then("the list of documents is returned for user to upload without UK Driving Licence")
    public void theListOfDocumentsIsReturnedForUserToUploadWithoutUKDrivingLicence(DataTable dataTable) {
    }

    @Then("status is returned as {int}\\(new) and no list of document")
    public void statusIsReturnedAsNewAndNoListOfDocument(int arg0) {
    }

    @And("POST idCheck_docUpload API with {string}")
    public void postIdCheck_docUploadAPIWith(String arg0) {
    }

    @When("user hits GET rightToRemain_Doc API")
    public void userHitsGETRightToRemain_DocAPI() {
    }

    @Then("message {string} should be returned")
    public void messageShouldBeReturned(String arg0) {
    }

    @Given("user is coming first time on PCA")
    public void userIsComingFirstTimeOnPCA() {
    }

    @Then("he goes through ID check \\(L1) with {string}")
    public void heGoesThroughIDCheckL1With(String arg1) {
    }

    @Then("he goes through residency check \\(L2) with {string}")
    public void heGoesThroughResidencyCheckL2With(String arg1) {
    }

    @And("GET rightToRemain_DocList API gets hit")
    public void getRightToRemain_DocListAPIGetsHit() {
    }

    @And("he goes through residency check \\(L1) with following documents")
    public void heGoesThroughResidencyCheckL1WithFollowingDocument(DataTable dataTable) {
    }

    @And("he goes through residency check \\(L2) with following documents")
    public void heGoesThroughResidencyCheckL2WithFollowingDocument(DataTable dataTable) {
    }

    @And("status is returned as {int}\\(Done) and documents used in ID check,residency check,right to remain check")
    public void statusIsReturnedAsDoneAndDocumentsUsedInIDCheckResidencyCheckRightToRemainCheck(int arg0) {
    }
}
