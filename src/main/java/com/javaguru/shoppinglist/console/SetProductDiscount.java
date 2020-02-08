package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;

class SetProductDiscount implements UserInput {

    Product setProductDiscount(Product product) {
        System.out.println("Enter product discount [%]: ");
        try {
            product.setDiscount(new BigDecimal(catchUserInput()));
        } catch (Exception e) {
            System.out.println("Wrong input format, use only digits");
        }
        return product;
    }
}
