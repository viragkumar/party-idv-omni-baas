package uk.co.santander.partyidv.omni.baas.restassured;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;

@Component
@RequiredArgsConstructor
public class HttpMethods {
    @Qualifier("anonymousRequestSpecification")
    private final RequestSpecification anonymousRequestSpecification;

    public Response post(String url, String request) throws Exception {
        return given().spec(anonymousRequestSpecification)
                .when()
                .body(request)
                .post(url);
    }

    public Response get(String url, String request) {
        return given().spec(anonymousRequestSpecification)
                .when()
                .get(url);
    }

    public Response put(String url, String request) {
        return given().spec(anonymousRequestSpecification)
                .when()
                .body(request)
                .put(url);
    }

    public Response delete(String url, String request) {
        return given().spec(anonymousRequestSpecification)
                .when()
                .body(request)
                .delete(url);
    }
}
