package com.javaguru.shoppinglist.console.input;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;


public class SetProductPrice implements CatchUserInput {

    public void setProductPrice(Product product) throws ExitException {
        System.out.println("Enter product price: ");
        String command = catchUserInput();
        try {
            product.setPrice(new BigDecimal(command));
        } catch (Exception e) {
            System.out.println("Wrong input format, use only digits!");
        }
    }
}