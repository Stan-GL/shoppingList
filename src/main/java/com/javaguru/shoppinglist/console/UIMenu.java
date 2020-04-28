package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.console.input.ExitException;
import com.javaguru.shoppinglist.console.service.UIService;
import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.service.RepositoryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class UIMenu {

    private final RepositoryItemService<Product> productService;
    private final RepositoryItemService<ShoppingCart> shoppingCartService;
    private final UIService<Product> productUIService;
    private final UIService<ShoppingCart> shoppingCartUIService;

    @Autowired
    public UIMenu(RepositoryItemService<Product> productService, RepositoryItemService<ShoppingCart> shoppingCartService,
                  UIService<Product> productUIService, UIService<ShoppingCart> shoppingCartUIService) {

        this.productService = productService;
        this.shoppingCartService = shoppingCartService;
        this.productUIService = productUIService;
        this.shoppingCartUIService = shoppingCartUIService;
    }

    public void run() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            printMainMenu();
            try {
                Integer userInput = Integer.valueOf(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        createProductInRepository();
                        break;
                    case 2:
                        findProduct();
                        break;
                    case 3:
                        boolean isOK = true;
                        while (isOK) {
                            printShoppingCartMenu();
                            try {
                                userInput = Integer.valueOf(scanner.nextLine());
                                switch (userInput) {
                                    case 1:
                                        createNewCart();
                                        break;
                                    case 2:
                                        findCart();
                                        break;
                                    case 3:
                                        deleteCart();
                                        break;
                                    case 4:
                                        addProductToCart();
                                        break;
                                    case 5:
                                        getListOfProductsInCart();
                                        break;
                                    case 6:
                                        getTotalValueOfCart();
                                        break;
                                    case 7:
                                        isOK = false;
                                }
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
//                                System.out.println("Wrong value!");
                            }
                        }
                        break;
                    case 4:
                        return;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
//                System.out.println("Wrong value!");
            }
        }
    }

    private void printMainMenu() {
        System.out.println();
        System.out.println("1. Create product in repository");
        System.out.println("2. Find product, ID:");
        System.out.println("3. Operations with shopping cart");
        System.out.println("4. Exit to finish. Or type 'exit' to cancel current operation.");
        System.out.println("==============================================================");
    }

    private void createProductInRepository() {
        try {
            System.out.println("New product was successfully added with ID = " + productUIService.insert().getProductId());
        } catch (ExitException e) {
            System.out.println(e.getMessage());
        }
    }

    private Product findProduct() {
        Product product;
        try {
            product = productUIService.getByID();
            if (product == null) {
                System.out.println("Product doesn't exist!");
                return null;
            } else {
                System.out.println("Search result: " + product);
                return product;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private void printShoppingCartMenu() {
        System.out.println();
        System.out.println("1. Create a new cart");
        System.out.println("2. Find cart, ID:");
        System.out.println("3. Delete cart, ID:");
        System.out.println("4. Add product to cart. Cart ID:");
        System.out.println("5. Get list of products in cart. Cart ID: ");
        System.out.println("6. Get total value of cart. Cart ID: ");
        System.out.println("7. Back to main menu. Or type 'exit' to cancel current operation.");
        System.out.println("=================================================================");
    }

    private void createNewCart() {
        try {
            System.out.println("Shopping cart created with ID: " + shoppingCartUIService.insert().getCartId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private ShoppingCart findCart() {
        ShoppingCart cart;
        try {
            cart = shoppingCartUIService.getByID();
            if (cart == null) {
                System.out.println("Cart does not exist!");
                return null;
            } else {
                System.out.println("Search result: " + cart);
                return cart;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private void deleteCart() {
        ShoppingCart cart;
        try {
            cart = shoppingCartUIService.getByID();
            if (cart != null) {
                shoppingCartUIService.deleteByID(cart);
                System.out.println("Cart successfully deleted.");
            } else {
                System.out.println("Cart doesn't exist!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void addProductToCart() {
        Product product = findProduct();
        if (product != null) {
            ShoppingCart cart = findCart();
            if (cart != null) {
                try {
                    shoppingCartUIService.addProductToCart(product, cart);
                    System.out.println("Added successfully.");
                } catch (ExitException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void getListOfProductsInCart() {
        ShoppingCart cart = findCart();
        if (cart != null) {
            try {
                System.out.println("Products in cart: " + shoppingCartUIService.getProductList(cart));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void getTotalValueOfCart() {
        ShoppingCart cart = findCart();
        if (cart != null) {
            try {
                System.out.print("Cart total value: " + shoppingCartUIService.getCartValue(cart));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
