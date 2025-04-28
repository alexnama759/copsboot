package com.example.orm.jpa;

import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class UniqueIdGenerator<T> {

    public T generateUniqueId() {
        if (UUID.class.equals(getType())) {
            return (T) UUID.randomUUID();
        }
        throw new UnsupportedOperationException("Unsupported ID type: " + getType());
    }

    private Class<?> getType() {
        return UUID.class;
    }

    public T getNextUniqueId() {
        return (T) UUID.randomUUID();
    }
}
