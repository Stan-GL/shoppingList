//package com.javaguru.shoppinglist.repository;
//
//import com.javaguru.shoppinglist.domain.Product;
//import com.javaguru.shoppinglist.service.validation.rules.ProductNameValidationRule;
//import org.junit.Test;
//
//import static org.junit.Assert.assertEquals;
//
//public class ProductNameValidationTest {
//
//    @Test
//    public void test1() {
//        Product product = new Product();
//        product.setName("qwertyuiopasdfghjklzxcvbnmqwerty");
//        ProductNameValidationRule rule = new ProductNameValidationRule();
//        boolean result = rule.validateItemName(product);
//        assertEquals(true, result);
//
//    }
//
//}