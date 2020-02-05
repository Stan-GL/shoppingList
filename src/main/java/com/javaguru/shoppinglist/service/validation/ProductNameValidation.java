package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

public class ProductNameValidation {

    public boolean validate(Product product) {
        if (product.getName().length() == 0) {
            throw new NullPointerException("Name must not be null!");
        } else {
            if (product.getName().length() < 3 || product.getName().length() > 32) {
                throw new IllegalArgumentException("Name must contain 3-32 symbols!");
            }
        }
        return true;
    }
}
