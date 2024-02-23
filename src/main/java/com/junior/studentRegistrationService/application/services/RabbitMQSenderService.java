package com.junior.studentRegistrationService.application.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.junior.studentRegistrationService.application.messages.StudentCreatedMessage;

@Service
public class RabbitMQSenderService {

    private RabbitTemplate rabbitTemplate;

    public RabbitMQSenderService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String name, String email) {
        StudentCreatedMessage message = new StudentCreatedMessage(name, email);
        rabbitTemplate.convertAndSend("student-exchange", "", message);
    }
}
