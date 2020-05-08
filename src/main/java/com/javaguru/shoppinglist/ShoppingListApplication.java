package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.console.UIMenu;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ShoppingListApplication {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        UIMenu console = context.getBean(UIMenu.class);
        console.run();

    }
}
