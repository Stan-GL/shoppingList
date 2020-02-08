package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.ShoppingCart;

public class ShoppingCartNameValidation implements ValidationRules {

    public boolean validate(ShoppingCart cart) {
        checkNotNull(cart);
        if (cart.getName().isEmpty()) {
            System.out.println("Cart name cannot be null!");
            return false;
        } else {
            return true;
        }
    }
}
