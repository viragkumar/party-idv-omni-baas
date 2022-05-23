package uk.co.santander.partyidv.omni.baas.client.jwt;

import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import uk.co.santander.partyidv.omni.baas.restassured.HttpMethods;

@Slf4j
@Component
@RequiredArgsConstructor
@EnableConfigurationProperties(TokenProperties.class)
public class TokenService {
    @Autowired
    public HttpMethods httpMethods;

    private final TokenProperties tokenProperties;

    public String generateToken() {

        Response response = httpMethods.get("/v1/oauth/service-token/postman-collection").then().extract().response();
        response.then().statusCode(200);
        return response.getBody().path("access_token");
    }


}
