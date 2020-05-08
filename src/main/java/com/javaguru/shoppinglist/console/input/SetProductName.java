package com.javaguru.shoppinglist.console.input;

import com.javaguru.shoppinglist.domain.Product;

public class SetProductName implements CatchUserInput {

    public void setProductName(Product product) throws ExitException {
        System.out.println("Enter product name: ");
        product.setProductName(catchUserInput());
    }

}