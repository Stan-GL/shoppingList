package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.domain.Product;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class ProductPriceValidationRuleTest {

    private ProductPriceValidationRule victim = new ProductPriceValidationRule();
    private Product product = new Product();

    @Test
    public void testNegativeProductPriceValidationRule() {
        product.setProductPrice(new BigDecimal("0"));
        boolean result = victim.validate(product);
        assertEquals(false, result);
    }

    @Test
    public void testPositiveProductPriceValidationRule() {
        product.setProductPrice(new BigDecimal("1000"));
        boolean result = victim.validate(product);
        assertEquals(true, result);
    }
}