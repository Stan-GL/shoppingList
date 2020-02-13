package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;

public class ProductPriceValidationRule implements ValidationRules<Product> {

    public boolean validate(Product product) {
        checkNotNull(product);
        BigDecimal var = new BigDecimal("0");
        if (product.getPrice() == null || (product.getPrice().compareTo(var) == -1) || (product.getPrice().compareTo(var) == 0)) {
            System.out.println("Price must be greater than 0!");
            return false;
        } else {
            return true;
        }
    }

}

