package com.junior.studentRegistrationService.infrastructure.mappers;

import java.lang.reflect.InvocationTargetException;

import org.mapstruct.TargetType;

import com.junior.studentRegistrationService.domain.ValueObject;

public interface ValueObjectMapper {

    static <V extends ValueObject<T>, T> T mapToValue(V valueObject) {
        return valueObject == null ? null : valueObject.getValue();
    }

    static <V extends ValueObject<T>, T> V mapFromValueObject(T value, @TargetType Class<V> valueObjectClass) {
        if (value == null) {
            return null;
        }

        try {
            V valueObject = valueObjectClass.getDeclaredConstructor(value.getClass()).newInstance(value);

            return valueObject;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
