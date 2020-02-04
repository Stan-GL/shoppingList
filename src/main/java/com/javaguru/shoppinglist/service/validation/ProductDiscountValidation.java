package com.javaguru.shoppinglist.service.validation;

import java.math.BigDecimal;

public class ProductDiscountValidation {

    public void validate(BigDecimal discount) {
        BigDecimal max = new BigDecimal("100");
        BigDecimal min = new BigDecimal("0");
        if ((discount.compareTo(max) == 1) || (discount.compareTo(min)) == -1) {
            throw new IllegalArgumentException("Discount must be within 0 - 100%!");
        }
    }


}
