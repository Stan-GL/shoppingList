package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.domain.Product;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ProductDiscountRangeValidationRuleTest {

    private ProductDiscountRangeValidationRule victim = new ProductDiscountRangeValidationRule();
    private Product product = new Product();

    @Test
    public void testNegativeCaseProductDiscountRangeValidationRule() {
        product.setProductDiscount(new BigDecimal(105));
        boolean result = victim.validate(product);
        assertFalse(result);
    }

    @Test
    public void testPositiveCaseProductDiscountRangeValidationRule() {
        product.setProductDiscount(new BigDecimal(5));
        boolean result = victim.validate(product);
        assertTrue(result);
    }
}