package com.javaguru.shoppinglist.console.input;

import com.javaguru.shoppinglist.domain.ShoppingCart;

public class SetShoppingCartName implements CatchUserInput {

    public void setShoppingCartName(ShoppingCart cart) throws ExitException {
        System.out.println("Enter cart name: ");
        cart.setCartName(catchUserInput());
    }
}