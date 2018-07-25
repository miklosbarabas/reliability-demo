package org.miklosbarabas.demo.configs;

import de.codecentric.spring.boot.chaos.monkey.configuration.AssaultProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ChaosMonkeyConfig {
    @Bean
    @Primary
    public AssaultProperties assaultProperties() {
        return new AssaultProperties();
    }
}
