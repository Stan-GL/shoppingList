package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;

public class ProductDiscountValidation {

    public void validate(Product product) {
        BigDecimal max = new BigDecimal("100");
        BigDecimal min = new BigDecimal("0");
        if ((product.getDiscount().compareTo(max) == 1) || (product.getDiscount().compareTo(min)) == -1) {
            throw new IllegalArgumentException("Discount must be within 0 - 100%!");
        }
        BigDecimal minPrice = new BigDecimal("20");
        if ((product.getPrice().compareTo(minPrice) == -1)) {
            product.setDiscount(new BigDecimal("0"));
            System.out.println("Discount cannot be assigned, check the price.");
        }
    }


}
