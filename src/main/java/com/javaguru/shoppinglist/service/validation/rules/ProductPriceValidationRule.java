package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.domain.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Qualifier("priceValidation")
public class ProductPriceValidationRule implements ValidationRules<Product> {

    public boolean validate(Product product) {
        checkNotNull(product);
        BigDecimal var = new BigDecimal("0");
        if (product.getProductPrice() == null || (product.getProductPrice().compareTo(var) == -1) || (product.getProductPrice().compareTo(var) == 0)) {
            System.out.println("Price must be greater than 0!");
            return false;
        } else {
            return true;
        }
    }

}

