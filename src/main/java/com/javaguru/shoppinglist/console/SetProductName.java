package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.Product;

class SetProductName implements UserInput {

    Product setProductName(Product product) {
        System.out.println("Enter product name: ");
        product.setName(catchUserInput());
        return product;
    }

}
