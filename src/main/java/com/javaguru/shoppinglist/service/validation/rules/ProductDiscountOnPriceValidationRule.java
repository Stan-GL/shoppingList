package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.domain.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
@Qualifier("discountOnPriceValidation")
public class ProductDiscountOnPriceValidationRule implements ValidationRules<Product> {

    @Override
    public boolean validate(Product product) {
        checkNotNull(product);
        BigDecimal minPrice = new BigDecimal("20");
        if ((product.getProductPrice().compareTo(minPrice) == -1)) {
            product.setProductDiscount(new BigDecimal("0"));
            System.out.println("Discount set to 0, check the price.");
            return true;
        } else {
            return true;
        }
    }

}
