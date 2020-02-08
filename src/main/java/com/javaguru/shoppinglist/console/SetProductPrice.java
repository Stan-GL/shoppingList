package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;

class SetProductPrice implements UserInput {

    Product setProductPrice(Product product) {
        System.out.println("Enter product price: ");
        try {
            product.setPrice(new BigDecimal(catchUserInput()));
        } catch (Exception e) {
            System.out.println("Wrong input format, use only digits!");
        }
        return product;
    }
}
