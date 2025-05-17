package com.challenge.sinister_buster.messaging;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessagingService {
    public static final String QUEUE_NAME = "sinister.queue";

    private final JmsTemplate jmsTemplate;

    public MessagingService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(String text) {
        jmsTemplate.convertAndSend(QUEUE_NAME, text);
        System.out.println("Mensagem enviada: " + text);
    }
}
