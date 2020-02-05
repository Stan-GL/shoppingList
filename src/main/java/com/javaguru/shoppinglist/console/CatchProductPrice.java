package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;

public class CatchProductPrice implements UserInput {

    @Override
    public Product catchUserInput(Product product) {
        System.out.println("Enter product price: ");
        product.setPrice(new BigDecimal(getFromScanner()));
        return product;
    }
}
