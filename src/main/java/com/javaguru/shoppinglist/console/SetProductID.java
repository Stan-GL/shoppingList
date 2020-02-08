package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.Product;

class SetProductID implements UserInput {

    Product setProductID(Product product) {
        System.out.println("Enter product ID [digits only]: ");
        try {
            product.setId(Long.valueOf(catchUserInput()));
        } catch (Exception e) {
            System.out.println("Wrong input format, use only digits!");
        }
        return product;
    }
}
