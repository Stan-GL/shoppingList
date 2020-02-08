package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.ShoppingCart;

class SetShoppingCartID implements UserInput {

    ShoppingCart setShoppingCartID(ShoppingCart cart) {
        System.out.println("Enter cart ID [digits only]: ");
        try {
            cart.setId(Long.valueOf(catchUserInput()));
        } catch (Exception e) {
            System.out.println("Wrong input format, use only digits!");
        }
        return cart;
    }
}
