package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.domain.ShoppingCart;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShoppingCartNameValidationRuleTest {

    private ShoppingCartNameValidationRule victim = new ShoppingCartNameValidationRule();
    private ShoppingCart cart = new ShoppingCart();

    @Test
    public void testNegativeShoppingCartNameValidationRule() {
        cart.setCartName(" ");
        Boolean result = victim.validate(cart);
        assertEquals(false, result);
    }

    @Test
    public void test2NegativeShoppingCartNameValidationRule() {
        cart.setCartName("");
        Boolean result = victim.validate(cart);
        assertEquals(false, result);
    }

    @Test
    public void testNPositiveShoppingCartNameValidationRule() {
        cart.setCartName("  1");
        Boolean result = victim.validate(cart);
        assertEquals(true, result);
    }

}