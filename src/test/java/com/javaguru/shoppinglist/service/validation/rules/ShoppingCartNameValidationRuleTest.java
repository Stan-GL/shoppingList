package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.repository.ShoppingCart;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShoppingCartNameValidationRuleTest {

    private ShoppingCartNameValidationRule victim = new ShoppingCartNameValidationRule();
    private ShoppingCart cart = new ShoppingCart();

    @Test
    public void testNegativeShoppingCartNameValidationRule() {
        cart.setName(" ");
        Boolean result = victim.validate(cart);
        assertEquals(false, result);
    }

    @Test
    public void testNPositiveShoppingCartNameValidationRule() {
        cart.setName("  1");
        Boolean result = victim.validate(cart);
        assertEquals(true, result);
    }

}