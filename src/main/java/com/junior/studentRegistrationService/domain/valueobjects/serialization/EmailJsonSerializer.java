package com.junior.studentRegistrationService.domain.valueobjects.serialization;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.junior.studentRegistrationService.domain.valueobjects.Email;

public class EmailJsonSerializer extends StdSerializer<Email> {

    public EmailJsonSerializer() {
        this(null);
    }

    public EmailJsonSerializer(Class<Email> t) {
        super(t);
    }
    
    @Override
    public void serialize(Email email, JsonGenerator generator, SerializerProvider provider) throws IOException {
        generator.writeString(email.getAddress());
    }
    
}
