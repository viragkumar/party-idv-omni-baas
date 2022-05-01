package uk.co.santander.partyidv.omni.baas.steps;

import uk.co.santander.partyidv.omni.baas.config.ApplicationConfig;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = {ApplicationConfig.class})
@Slf4j
@RequiredArgsConstructor
public class DDVLivenessSteps {

}
