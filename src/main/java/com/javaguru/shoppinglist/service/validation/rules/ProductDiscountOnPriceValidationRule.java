package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;

public class ProductDiscountOnPriceValidationRule implements ValidationRules<Product> {

    @Override
    public boolean validate(Product product) {
        checkNotNull(product);
        BigDecimal minPrice = new BigDecimal("20");
        if ((product.getPrice().compareTo(minPrice) == -1)) {
            product.setDiscount(new BigDecimal("0"));
            System.out.println("Discount set to 0, check the price.");
            return true;
        } else {
            return true;
        }
    }

}
