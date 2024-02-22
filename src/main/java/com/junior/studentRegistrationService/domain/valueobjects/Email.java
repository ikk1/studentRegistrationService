package com.junior.studentRegistrationService.domain.valueobjects;

public class Email {

    private String address;

    public Email(String address) {

        if (address == null || !address.matches(""))
            throw new IllegalArgumentException("Invalid e-mail address!");

        this.address = address;
    }

}
