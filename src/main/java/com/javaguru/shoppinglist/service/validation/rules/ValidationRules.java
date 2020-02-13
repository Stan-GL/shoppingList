package com.javaguru.shoppinglist.service.validation.rules;

public interface ValidationRules<T> {

    default void checkNotNull(T object) {
        if (object == null) {
            throw new NullPointerException("Object doesn't exist!");
        }
    }

    boolean validate(T object);
}
