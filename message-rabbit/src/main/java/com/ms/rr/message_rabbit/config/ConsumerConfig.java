package com.ms.rr.message_rabbit.config;

import com.ms.rr.message_rabbit.service.Listener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsumerConfig {

    private final Logger logger = LoggerFactory.getLogger(ConsumerConfig.class);

    private final ConnectionFactory connectionFactory;
    private final Listener basicListener;
    private final SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory;


    public ConsumerConfig(ConnectionFactory connectionFactory, Listener basicListener,
                          SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory) {
        this.connectionFactory = connectionFactory;
        this.basicListener = basicListener;
        this.rabbitListenerContainerFactory = rabbitListenerContainerFactory;
    }


    @Bean
    public MessageListenerContainer listenerContainer() {
        var container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addQueueNames("queue-communication");
        container.setMessageListener(basicListener);
        return container;
    }
}
