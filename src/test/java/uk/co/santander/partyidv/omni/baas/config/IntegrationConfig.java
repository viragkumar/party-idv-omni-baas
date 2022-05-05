package uk.co.santander.partyidv.omni.baas.config;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.Filter;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.ProxySpecification;
import io.restassured.specification.RequestSpecification;
import lombok.AllArgsConstructor;
import org.apache.http.HttpHeaders;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import uk.co.santander.commons.test.restassured.LogOutputStream;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableCaching
@AllArgsConstructor
@EnableConfigurationProperties({
    IntegrationProperties.class
})
public class IntegrationConfig {

    private static  final String PROXY_HOST = "dia2.santanderuk.gs.corp";
    private static  final int PROXY_PORT = 8080;

    private final IntegrationProperties integrationProperties;

    @Bean
    public AmazonSQS sqs() {
        // Selectively set proxy when working with SQS
        if (integrationProperties.isProxyEnabled()) {
            ClientConfiguration config = new ClientConfiguration();
            config.setProtocol(Protocol.HTTP);
            config.setProxyHost(PROXY_HOST);
            config.setProxyPort(PROXY_PORT);

            return AmazonSQSClientBuilder.standard()
                    .withClientConfiguration(config)
                    .withRegion(Regions.EU_WEST_2)
                    .build();
        }

        return AmazonSQSClientBuilder.standard()
                .withRegion(Regions.EU_WEST_2)
                .build();
    }

    @Bean("anonymousRequestSpecification")
    public RequestSpecification anonymousRequestSpecification() {
        return requestSpecBuilder()
                .setBaseUri(integrationProperties.getApiGatewayUrl())
                .addFilters(loggingFilters())
                .addHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    @Bean("loggedInRequestSpecification")
    public RequestSpecification loggedInRequestSpecification() {
        return requestSpecBuilder()
                .setBaseUri(integrationProperties.getApiGatewayUrl())
                .addFilters(loggingFilters())
                .addHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }


    private RequestSpecBuilder requestSpecBuilder() {
        RequestSpecBuilder builder = new RequestSpecBuilder()
                .setConfig(RestAssuredConfig.config());

        // Selectively set proxy on the request
        if (integrationProperties.isProxyEnabled()) {
            builder.setProxy(ProxySpecification.host(PROXY_HOST)
                    .and().withPort(PROXY_PORT)
                    .and().withAuth(integrationProperties.getProxyUsername(), integrationProperties.getProxyPassword()));
        }

        return builder;
    }

    private List<Filter> loggingFilters() {
        return Arrays.asList(
                new RequestLoggingFilter(
                        LogDetail.ALL,
                        true,
                        new PrintStream(new LogOutputStream("RequestLogger"), true, StandardCharsets.UTF_8)),
                new ResponseLoggingFilter(
                        LogDetail.ALL,
                        true,
                        new PrintStream(new LogOutputStream("ResponseLogger"), true, StandardCharsets.UTF_8))
        );
    }
}
