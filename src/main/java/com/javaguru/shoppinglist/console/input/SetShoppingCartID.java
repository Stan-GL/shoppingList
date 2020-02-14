package com.javaguru.shoppinglist.console.input;

import com.javaguru.shoppinglist.repository.ShoppingCart;

public class SetShoppingCartID implements CatchUserInput {

    public ShoppingCart setShoppingCartID(ShoppingCart cart) throws ExitException {
        System.out.println("Enter cart ID [digits only]: ");
        String command = catchUserInput();
        try {
            cart.setId(Long.valueOf(command));
        } catch (Exception e) {
            System.out.println("Wrong input format, use only digits!");
            return null;
        }
        return cart;
    }
}
