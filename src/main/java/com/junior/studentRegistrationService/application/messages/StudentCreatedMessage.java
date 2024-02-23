package com.junior.studentRegistrationService.application.messages;

import java.io.Serializable;

public class StudentCreatedMessage implements Serializable{
    
    private String name;
    private String email;

    public StudentCreatedMessage(String name, String email) {
        this.name = name;
        this.email = email;
    }

}
