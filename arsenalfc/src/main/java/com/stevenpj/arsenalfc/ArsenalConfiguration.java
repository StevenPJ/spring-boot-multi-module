package com.stevenpj.arsenalfc;

import com.stevenpj.library.MatchUpdate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import java.util.function.Consumer;

@Configuration
@ComponentScan
@EnableJms
public class ArsenalConfiguration {

    @Bean
    Consumer<MatchUpdate> arsenalEventPublisher(JmsTemplate jmsTemplate) {
        return update -> jmsTemplate.convertAndSend("matchUpdates", update);
    }
}
