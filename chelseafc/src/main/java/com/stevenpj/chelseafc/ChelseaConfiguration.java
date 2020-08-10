package com.stevenpj.chelseafc;

import com.stevenpj.library.MatchUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@ComponentScan
public class ChelseaConfiguration {

    @Bean
    Consumer<MatchUpdate> chelseaEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        return applicationEventPublisher::publishEvent;
    }
}
