package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.repository.ShoppingCart;
import com.javaguru.shoppinglist.service.validation.rules.ShoppingCartNameValidationRule;

public class ShoppingCartValidationService implements ValidationService<ShoppingCart> {

    @Override
    public boolean validateItemName(ShoppingCart cart) {
        ShoppingCartNameValidationRule validation = new ShoppingCartNameValidationRule();
        return validation.validate(cart);
    }

    @Override
    public boolean validateItemPrice(ShoppingCart object) {
        return false;
    }

    @Override
    public boolean validateItemDiscount(ShoppingCart object) {
        return false;
    }


}
