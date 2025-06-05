package com.ms.rr.message_rabbit.service;

import com.ms.rr.message_rabbit.config.RabbitConfig;
import com.ms.rr.message_rabbit.dto.AccountsMsgDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    private final Logger log = LoggerFactory.getLogger(MessageListener.class);

    private final MockEmailService emailService;

    public MessageListener(MockEmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void receive(AccountsMsgDto accountsMsgDto) {
        log.info("Received account message: {}", accountsMsgDto);

        emailService.sendEmail(
                accountsMsgDto.email(),
                "Bem-vindo!",
                "Olá " + accountsMsgDto.name() + ", sua conta foi criada!"
        );
    }
}
