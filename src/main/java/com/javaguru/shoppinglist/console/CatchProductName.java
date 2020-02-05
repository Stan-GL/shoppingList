package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.Product;

public class CatchProductName implements UserInput {

    @Override
    public Product catchUserInput(Product product) {
        System.out.println("Enter product name [3-32 symbols]: ");
        product.setName(getFromScanner());
        return product;
    }

}
