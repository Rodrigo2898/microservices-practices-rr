package com.ms.rr.accounts.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerConfig {

    @Bean
    public Queue queueCommunication() {
        return new Queue("queue-communication", true);
    }

    @Bean
    public Exchange directExchange() {
        return ExchangeBuilder
                .directExchange("DIRECT-EXCHANGE")
                .durable(true)
                .build();
    }

    @Bean
    public Binding directBinding() {
        return BindingBuilder
                .bind(queueCommunication())
                .to(directExchange())
                .with("TO-QUEUE")
                .noargs();
    }

    @Bean
    public MessageConverter messageConverter(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}
