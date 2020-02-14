package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.domain.Product;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ProductNameValidationRuleTest {

    private Map<Long, Product> productRepository = new HashMap<>();
    private ProductNameValidationRule victim = new ProductNameValidationRule(productRepository);
    private Product product = new Product();
    private Product apple = new Product();

    @Test
    public void testNegativeProductNameExclusiveness() {
        apple.setName("apple");
        product.setName("apple");
        productRepository.put(0L, apple);
        Boolean result = victim.validate(product);
        assertEquals(false, result);
    }

    @Test
    public void testPositiveProductNameExclusiveness() {
        apple.setName("apple");
        product.setName("orange");
        productRepository.put(0L, apple);
        Boolean result = victim.validate(product);
        assertEquals(true, result);
    }

    @Test
    public void testNegativeProductNameValidationRule() {
        product.setName("   e   r  ");
        Boolean result = victim.validate(product);
        assertEquals(false, result);
    }

    @Test
    public void test2NegativeProductNameValidationRule() {
        product.setName("");
        Boolean result = victim.validate(product);
        assertEquals(false, result);
    }

    @Test
    public void test3NegativeProductNameValidationRule() {
        product.setName("as");
        Boolean result = victim.validate(product);
        assertEquals(false, result);
    }

    @Test
    public void test4NegativeProductNameValidationRule() {
        product.setName("123456789012345678901234567890123");
        Boolean result = victim.validate(product);
        assertEquals(false, result);
    }

    @Test
    public void testPositiveProductNameValidationRule() {
        product.setName("  e  r   t ");
        Boolean result = victim.validate(product);
        assertEquals(true, result);
    }


}