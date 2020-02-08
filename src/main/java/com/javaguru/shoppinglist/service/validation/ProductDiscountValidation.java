package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;

public class ProductDiscountValidation implements ValidationRules {

    public boolean validateDiscountRange(Product product) {
        checkNotNull(product);
        if (product.getDiscount() != null) {
            BigDecimal max = new BigDecimal("100");
            BigDecimal min = new BigDecimal("0");
            if ((product.getDiscount().compareTo(max) == 1) || (product.getDiscount().compareTo(min)) == -1) {
                System.out.println("Discount must be within 0 - 100%!");
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public boolean validatePriceDependency(Product product) {
        checkNotNull(product);
        BigDecimal minPrice = new BigDecimal("20");
        if ((product.getPrice().compareTo(minPrice) == -1)) {
            product.setDiscount(new BigDecimal("0"));
            System.out.println("Discount cannot be assigned, check the price.");
            return true;
        } else {
            return true;
        }
    }


}
