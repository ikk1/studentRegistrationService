package com.junior.studentRegistrationService.infrastructure.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.junior.studentRegistrationService.infrastructure.messaging.StudentCreatedMessage;

@Service
public class RabbitMQSenderService {

    private RabbitTemplate rabbitTemplate;

    public RabbitMQSenderService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String name, String email) {
        try {
            StudentCreatedMessage message = new StudentCreatedMessage(name, email);
            rabbitTemplate.convertAndSend("student.exchange", "student.created", message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}