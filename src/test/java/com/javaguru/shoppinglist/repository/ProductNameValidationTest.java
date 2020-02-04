package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.service.validation.ProductNameValidation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductNameValidationTest {

    @Test
    public void test1() {
        String name = "qwertyuiopasdfghjklzxcvbnmqwerty";
        ProductNameValidation rule = new ProductNameValidation();
        boolean result = rule.validate(name);
        assertEquals(true, result);

    }

}