package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.service.validation.rules.ShoppingCartNameValidationRule;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartValidationService implements ValidationService<ShoppingCart> {

    @Override
    public boolean validateName(ShoppingCart cart) {
        ShoppingCartNameValidationRule validation = new ShoppingCartNameValidationRule();
        return validation.validate(cart);
    }

    @Override
    public boolean validatePrice(ShoppingCart object) {
        return false;
    }

    @Override
    public boolean validateDiscount(ShoppingCart object) {
        return false;
    }


}
