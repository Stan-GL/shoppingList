package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.ShoppingCart;

class SetShoppingCartName implements UserInput {

    ShoppingCart setShoppingCartName(ShoppingCart cart) {
        System.out.println("Enter cart name: ");
        cart.setName(catchUserInput());
        return cart;
    }
}
