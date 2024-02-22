package com.junior.studentRegistrationService.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.junior.studentRegistrationService.domain.valueobjects.Email;
import com.junior.studentRegistrationService.domain.valueobjects.serialization.EmailJsonDeserializer;
import com.junior.studentRegistrationService.domain.valueobjects.serialization.EmailJsonSerializer;

@Configuration
public class JacksonConfig {

    @Bean
    ObjectMapper objectMapper() {
        
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule simpleModule = new SimpleModule();

        simpleModule.addSerializer(Email.class, new EmailJsonSerializer());
        simpleModule.addDeserializer(Email.class, new EmailJsonDeserializer());

        objectMapper.registerModule(simpleModule);
        return objectMapper;
    }

}
