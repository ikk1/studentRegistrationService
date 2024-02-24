package com.junior.studentregistrationservice.infrastructure.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.junior.studentregistrationservice.infrastructure.messaging.StudentCreatedMessage;

@Service
public class RabbitMQSenderService {

    private RabbitTemplate rabbitTemplate;
    private ObjectMapper parser;

    public RabbitMQSenderService(RabbitTemplate rabbitTemplate, ObjectMapper parser) {
        this.rabbitTemplate = rabbitTemplate;
        this.parser = parser;
    }

    public void sendMessage(String name, String email) {
        try {
            StudentCreatedMessage message = new StudentCreatedMessage(name, email);
            rabbitTemplate.convertAndSend("student.exchange", "student.created", parser.writeValueAsString(message));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}