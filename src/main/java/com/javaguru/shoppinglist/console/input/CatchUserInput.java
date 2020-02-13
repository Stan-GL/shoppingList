package com.javaguru.shoppinglist.console.input;

import java.util.Scanner;

public interface CatchUserInput {

    default String catchUserInput() throws ExitException {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        if (command.equals("exit")) {
            throw new ExitException("Operation canceled.");
        }
        return command;
    }

}