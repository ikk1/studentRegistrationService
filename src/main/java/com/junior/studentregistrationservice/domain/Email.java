package com.junior.studentregistrationservice.domain;

public class Email implements ValueObject<String> {

    private String value;

    public Email(String address) {

        if (address == null || !address.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"))
            throw new IllegalArgumentException("Invalid e-mail address!");

        this.value = address;
    }

    public String getAddress() {
        return value;
    }

    public String getValue() {
        return value;
    }
}
