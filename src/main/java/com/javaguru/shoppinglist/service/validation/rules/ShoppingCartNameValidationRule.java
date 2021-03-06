package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.domain.ShoppingCart;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartNameValidationRule implements ValidationRules<ShoppingCart> {

    public boolean validate(ShoppingCart cart) {
        checkNotNull(cart);
        int name = cart.getCartName().replaceAll(" ", "").length();
        if (name == 0) {
            System.out.println("Cart name cannot be null!");
            return false;
        } else {
            return true;
        }
    }


}
