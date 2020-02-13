package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ProductDiscountOnPriceValidationRuleTest {


    private ProductDiscountOnPriceValidationRule victim = new ProductDiscountOnPriceValidationRule();
    private Product product = new Product();

    @Test
    public void testNegativeCaseValidateDiscountDependencyOnPrice() {
        product.setPrice(new BigDecimal("10"));
        product.setDiscount(new BigDecimal("10"));
        victim.validate(product);
        BigDecimal result = product.getDiscount();
        assertEquals(new BigDecimal("0"), result);
    }

    @Test
    public void testPositiveCaseValidateDiscountDependencyOnPrice() {
        product.setPrice(new BigDecimal("20"));
        product.setDiscount(new BigDecimal("20"));
        victim.validate(product);
        BigDecimal result = product.getDiscount();
        assertEquals(new BigDecimal("20"), result);
    }

}