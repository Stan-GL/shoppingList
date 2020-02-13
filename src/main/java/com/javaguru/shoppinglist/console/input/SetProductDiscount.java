package com.javaguru.shoppinglist.console.input;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;

public class SetProductDiscount implements CatchUserInput {

    public void setProductDiscount(Product product) throws ExitException {
        System.out.println("Enter product discount [%]: ");
        String command = catchUserInput();
        try {
            product.setDiscount(new BigDecimal(command));
        } catch (Exception e) {
            System.out.println("Wrong input format, use only digits");
        }
    }
}