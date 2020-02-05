package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;

public class ProductPriceValidation {

    public boolean validate(Product product) {
        BigDecimal var = new BigDecimal("0");
        if ((product.getPrice().compareTo(var) == -1) || (product.getPrice().compareTo(var) == 0)) {
            throw new IllegalArgumentException("Price must be greater than 0!");
        }
        return true;
    }
}
