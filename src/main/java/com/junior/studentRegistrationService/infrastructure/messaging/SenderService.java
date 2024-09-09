package com.junior.studentRegistrationService.infrastructure.messaging;

public interface SenderService {
    void sendMessage(String name, String email);
}