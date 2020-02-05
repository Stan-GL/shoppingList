package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.Product;

import java.util.Scanner;

public interface UserInput {

    default String getFromScanner() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    Product catchUserInput(Product product);
}
