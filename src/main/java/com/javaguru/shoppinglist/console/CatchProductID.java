package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.Product;

public class CatchProductID implements UserInput {

    @Override
    public Product catchUserInput(Product product) {
        System.out.println("Enter product ID [digits only]: ");
        product.setId(Long.valueOf(getFromScanner()));
        return product;
    }
}
