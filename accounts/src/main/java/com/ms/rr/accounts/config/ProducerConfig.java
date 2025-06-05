package com.ms.rr.accounts.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerConfig {

    public static final String QUEUE_NAME = "account.created.queue";
    public static final String EXCHANGE_NAME = "account.notification.exchange";
    public static final String ROUTING_KEY = "account.created.notification";

    @Bean
    public Queue queueCommunication() {
        return new Queue(QUEUE_NAME, true);
    }

    @Bean
    public Exchange directExchange() {
        return ExchangeBuilder
                .directExchange(EXCHANGE_NAME)
                .durable(true)
                .build();
    }

    @Bean
    public Binding directBinding() {
        return BindingBuilder
                .bind(queueCommunication())
                .to(directExchange())
                .with(ROUTING_KEY)
                .noargs();
    }

    @Bean
    public MessageConverter messageConverter(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}
