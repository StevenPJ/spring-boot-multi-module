package com.stevenpj.arsenalfc;

import com.stevenpj.library.MatchUpdate;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@ComponentScan
public class ArsenalConfiguration {

    @Bean
    Consumer<MatchUpdate> arsenalEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        return applicationEventPublisher::publishEvent;
    }
}
