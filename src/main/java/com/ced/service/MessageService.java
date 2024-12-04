package com.ced.service;

import com.ced.model.MessageRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final RabbitTemplate rabbitTemplate;
    private final String queueName;

    public MessageService(RabbitTemplate rabbitTemplate, @Value("${amqp.queue-name}") String queueName) {
        this.rabbitTemplate = rabbitTemplate;
        this.queueName = queueName;
    }

    public void sendMessage(MessageRequest message) {
        rabbitTemplate.convertAndSend(queueName, message);
    }
}