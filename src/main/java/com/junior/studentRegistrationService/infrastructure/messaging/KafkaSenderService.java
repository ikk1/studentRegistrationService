package com.junior.studentRegistrationService.infrastructure.messaging;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KafkaSenderService implements SenderService {

      @Value("${student.kafka.email.topic}")
    private String TOPIC;

    private KafkaTemplate<String, String> kafkaTemplate;
    private ObjectMapper parser;

    public KafkaSenderService(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper parser) {
        this.kafkaTemplate = kafkaTemplate;
        this.parser = parser;
    }

    @Override
    public void sendMessage(String name, String email) {
        try {
            StudentCreatedMessage message = new StudentCreatedMessage(name, email);
            kafkaTemplate.send(TOPIC, parser.writeValueAsString(message));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}