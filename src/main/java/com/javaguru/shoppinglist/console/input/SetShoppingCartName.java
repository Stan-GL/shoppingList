package com.javaguru.shoppinglist.console.input;

import com.javaguru.shoppinglist.repository.ShoppingCart;

public class SetShoppingCartName implements CatchUserInput {

    public void setShoppingCartName(ShoppingCart cart) throws ExitException {
        System.out.println("Enter cart name: ");
        cart.setName(catchUserInput());
    }
}