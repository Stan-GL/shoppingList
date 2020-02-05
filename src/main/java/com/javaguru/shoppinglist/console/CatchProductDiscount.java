package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;

public class CatchProductDiscount implements UserInput {

    @Override
    public Product catchUserInput(Product product) {
        System.out.println("Enter product discount [%]: ");
        product.setDiscount(new BigDecimal(getFromScanner()));
        return product;
    }
}
