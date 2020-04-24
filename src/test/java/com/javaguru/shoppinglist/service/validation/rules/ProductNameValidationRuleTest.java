package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.CRUD;
import com.javaguru.shoppinglist.repository.InMemoryRepository;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductNameValidationRuleTest {

    private CRUD mainRepository = new InMemoryRepository();

    private ProductNameValidationRule victim = new ProductNameValidationRule(mainRepository);
    private Product product = new Product();
    private Product apple = new Product();

    @Test
    public void testNegativeProductNameExclusiveness() {
        apple.setProductName("apple");
        product.setProductName("apple");
        mainRepository.getProductRepository().put(0L, apple);
        Boolean result = victim.validate(product);
        assertEquals(false, result);
    }

    @Test
    public void testPositiveProductNameExclusiveness() {
        apple.setProductName("apple");
        product.setProductName("orange");
        mainRepository.getProductRepository().put(0L, apple);
        Boolean result = victim.validate(product);
        assertEquals(true, result);
    }

    @Test
    public void testNegativeProductNameValidationRule() {
        product.setProductName("   e   r  ");
        Boolean result = victim.validate(product);
        assertEquals(false, result);
    }

    @Test
    public void test2NegativeProductNameValidationRule() {
        product.setProductName("");
        Boolean result = victim.validate(product);
        assertEquals(false, result);
    }

    @Test
    public void test3NegativeProductNameValidationRule() {
        product.setProductName("as");
        Boolean result = victim.validate(product);
        assertEquals(false, result);
    }

    @Test
    public void test4NegativeProductNameValidationRule() {
        product.setProductName("123456789012345678901234567890123");
        Boolean result = victim.validate(product);
        assertEquals(false, result);
    }

    @Test
    public void testPositiveProductNameValidationRule() {
        product.setProductName("  e  r   t ");
        Boolean result = victim.validate(product);
        assertEquals(true, result);
    }


}