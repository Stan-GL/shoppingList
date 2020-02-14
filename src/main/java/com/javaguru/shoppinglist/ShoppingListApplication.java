package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.console.UIMenu;

class ShoppingListApplication {

    public static void main(String[] args) {

        DependencyInjectionHelper helper = new DependencyInjectionHelper();
        UIMenu uiMenu = helper.createApplication();
        uiMenu.run();
    }
}
