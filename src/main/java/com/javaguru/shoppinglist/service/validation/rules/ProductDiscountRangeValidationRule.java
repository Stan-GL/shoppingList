package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.domain.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Qualifier("discountRangeValidation")
public class ProductDiscountRangeValidationRule implements ValidationRules<Product> {

    @Override
    public boolean validate(Product product) {
        checkNotNull(product);
        BigDecimal max = new BigDecimal("100");
        BigDecimal min = new BigDecimal("0");
        if ((product.getProductDiscount() == null) || (product.getProductDiscount().compareTo(max) == 1)
                || (product.getProductDiscount().compareTo(min)) == -1) {
            System.out.println("Discount must be within 0 - 100%!");
            return false;
        } else {
            return true;
        }
    }


}
