package com.javaguru.shoppinglist.service.validation;

public class ProductNameValidation {

    public boolean validate(String name) {
        if (name.length() == 0) {
            throw new NullPointerException("Name must not be null!");
        } else {
            if (name.length() < 3 || name.length() > 32) {
                throw new IllegalArgumentException("Name must contain 3-32 symbols!");
            }
        }
        return true;
    }

}
