package com.junior.studentregistrationservice.domain;

public class Email implements ValueObject<String> {

    private final String value;

    public Email(String value) {

        if (value == null || !value.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"))
            throw new IllegalArgumentException("Invalid e-mail address!");
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
