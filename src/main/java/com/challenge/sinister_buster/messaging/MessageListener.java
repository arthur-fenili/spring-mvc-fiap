package com.challenge.sinister_buster.messaging;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @JmsListener(destination = MessagingService.QUEUE_NAME)
    public void receive(String message) {
        System.out.println("Mensagem recebida: " + message);
    }
}
