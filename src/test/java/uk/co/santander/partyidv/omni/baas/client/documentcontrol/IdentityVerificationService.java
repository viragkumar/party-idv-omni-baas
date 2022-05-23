package uk.co.santander.partyidv.omni.baas.client.documentcontrol;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;

@Slf4j
@Component
@RequiredArgsConstructor
@EnableConfigurationProperties(DocumentControlProperties.class)
public class IdentityVerificationService {
    @Qualifier("anonymousRequestSpecification")
    private final RequestSpecification anonymousRequestSpecification;

    private final DocumentControlProperties tokenProperties;

    public String getIdentityByCustomer(String accessToken, String customerId) {
        String url = String.format("/v1/customers/%s/identity", customerId);

        Response response = given().spec(anonymousRequestSpecification.header("Authorization", "Bearer " + accessToken))
                .when()
                .get(url)
                .then().extract().response();

        response.then().statusCode(200);
        log.info("customer identity: " + response.getBody().asString());
        return response.getBody().asString();
    }


}
