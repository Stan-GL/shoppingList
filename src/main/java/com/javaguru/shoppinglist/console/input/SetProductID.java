package com.javaguru.shoppinglist.console.input;

import com.javaguru.shoppinglist.domain.Product;

public class SetProductID implements CatchUserInput {

    public Product setProductID(Product product) throws ExitException {
        System.out.println("Enter product ID [digits only]: ");
        String command = catchUserInput();
        try {
            product.setId(Long.valueOf(command));
        } catch (Exception e) {
            System.out.println("Wrong input format, use only digits!");
            return null;
        }
        return product;
    }
}
