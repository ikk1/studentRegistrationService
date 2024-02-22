package com.junior.studentRegistrationService.domain.valueobjects.serialization;

import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.junior.studentRegistrationService.domain.valueobjects.Email;

public class EmailJsonDeserializer extends StdDeserializer<Email> {

    public EmailJsonDeserializer() {
        this(null);
    }

    public EmailJsonDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Email deserialize(JsonParser parser, DeserializationContext context) throws IOException, JacksonException {
        String address = parser.getText();
        return new Email(address);
    }

}
