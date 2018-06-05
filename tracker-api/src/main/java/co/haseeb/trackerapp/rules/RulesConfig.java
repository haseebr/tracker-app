package co.haseeb.trackerapp.rules;

import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RulesConfig {

    @Bean
    public RulesEngine rulesEngine() {
        return new DefaultRulesEngine();
    }

    @Bean
    public Rules rules() {
        Rules rules = new Rules();
        rules.register(new CheckEngineLightRule());
        rules.register(new EngineRpmRule());
        rules.register(new LowEngineCoolantRule());
        rules.register(new LowFuelVolumeRule());
        rules.register(new LowTirePressureRule());
        return rules;
    }
}
