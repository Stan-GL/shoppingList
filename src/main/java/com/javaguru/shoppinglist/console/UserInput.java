package com.javaguru.shoppinglist.console;

import java.util.Scanner;

public interface UserInput {

    default String catchUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


}
