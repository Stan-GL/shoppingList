package com.javaguru.shoppinglist.service.validation;

import java.math.BigDecimal;

public class ProductPriceValidation {

    public boolean validate(BigDecimal price) {
        BigDecimal var = new BigDecimal("0");
        if ((price.compareTo(var) == -1) || (price.compareTo(var) == 0)) {
            throw new IllegalArgumentException("Price must be greater than 0!");
        }
        return true;
    }
}
