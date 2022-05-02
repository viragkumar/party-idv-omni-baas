package uk.co.santander.partyidv.omni.baas.steps;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import uk.co.santander.partyidv.omni.baas.config.ApplicationConfig;

@CucumberContextConfiguration
@SpringBootTest(classes = ApplicationConfig.class)
public class CucumberContextConfig {
}