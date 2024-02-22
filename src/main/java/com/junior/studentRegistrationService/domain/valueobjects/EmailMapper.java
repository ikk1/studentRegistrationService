package com.junior.studentRegistrationService.domain.valueobjects;

import org.mapstruct.Mapper;

@Mapper
public interface EmailMapper {

    default String map(Email email) {
        return email.getAddress();
    }

    default Email map(String email) {
        return new Email(email);
    }

}
