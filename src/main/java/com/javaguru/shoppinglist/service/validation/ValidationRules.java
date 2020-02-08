package com.javaguru.shoppinglist.service.validation;

public interface ValidationRules {

    default void checkNotNull(Object object) {
        if (object == null) {
            throw new NullPointerException("Object or field doesn't exist!");
        }
    }
}
