package uk.co.santander.partyidv.omni.baas.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;

@Configuration
@EnableRetry
@EnableAutoConfiguration
@RequiredArgsConstructor
@ComponentScan(basePackages = {"uk.co.santander.partyidv.omni.baas"})
public class ApplicationConfig {
}

