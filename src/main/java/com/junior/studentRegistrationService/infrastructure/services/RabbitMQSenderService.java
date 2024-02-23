package com.junior.studentRegistrationService.infrastructure.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.junior.studentRegistrationService.infrastructure.messaging.StudentCreatedMessage;

@Service
public class RabbitMQSenderService {

    private RabbitTemplate rabbitTemplate;

    public RabbitMQSenderService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String name, String email) {
        StudentCreatedMessage message = new StudentCreatedMessage(name, email);
        String jsonStudent = new Gson().toJson(message);
        rabbitTemplate.convertAndSend("student-exchange", "student.created", jsonStudent);
    }
}
