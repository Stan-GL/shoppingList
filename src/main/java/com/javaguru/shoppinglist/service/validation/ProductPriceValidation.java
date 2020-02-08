package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;

public class ProductPriceValidation implements ValidationRules {

    public boolean validate(Product product) {
        checkNotNull(product);
        if (product.getPrice() != null) {
            BigDecimal var = new BigDecimal("0");
            if ((product.getPrice().compareTo(var) == -1) || (product.getPrice().compareTo(var) == 0)) {
                System.out.println("Price must be greater than 0!");
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}


