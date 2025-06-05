package com.ms.rr.message_rabbit.service;

import org.springframework.stereotype.Service;

@Service
public class MockEmailService {

    public void sendEmail(String to, String subject, String text) {
        System.out.println("📧 [MOCK] Enviando e-mail para: " + to);
        System.out.println("Assunto: " + subject);
        System.out.println("Conteúdo: " + text);
        System.out.println("----------------------------------");
    }
}

