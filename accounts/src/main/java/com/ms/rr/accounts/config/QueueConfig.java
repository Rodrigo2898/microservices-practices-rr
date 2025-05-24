package com.ms.rr.accounts.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class QueueConfig {
    @Bean
    public Queue firstQueue() {
        return QueueBuilder
                .durable("QUEUE-BASIC")
                .build();
    }
}