package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.domain.Product;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class ProductDiscountRangeValidationRuleTest {

    private ProductDiscountRangeValidationRule victim = new ProductDiscountRangeValidationRule();
    private Product product = new Product();

    @Test
    public void testNegativeCaseProductDiscountRangeValidationRule() {
        product.setDiscount(new BigDecimal(105));
        boolean result = victim.validate(product);
        assertEquals(false, result);
    }

    @Test
    public void testPositiveCaseProductDiscountRangeValidationRule() {
        product.setDiscount(new BigDecimal(5));
        boolean result = victim.validate(product);
        assertEquals(true, result);
    }
}