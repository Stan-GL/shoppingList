package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.service.ProductAndCartService;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class ConsoleUI {

    private ProductAndCartService productAndCartService = new ProductAndCartService();

    public void run() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product, ID:");
                System.out.println("3. Operations with shopping cart");
                System.out.println("4. Exit");

                Product product;
                Long id;

                Integer userInput = Integer.valueOf(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        insertProduct();
                        id = productAndCartService.getLastAddedProductID();
                        System.out.println("Product created, ID: " + id);
                        break;
                    case 2:
                        product = findProductByID();
                        if (product == null) {
                            System.out.println("Product doesn't exist!");
                            break;
                        } else {
                            System.out.println("Search result: " + product);
                            break;
                        }
                    case 3:
                        boolean flag = true;
                        while (flag) {
                            try {
                                System.out.println("1. Create a new shopping cart");
                                System.out.println("2. Find cart, ID:");
                                System.out.println("3. Delete cart, ID:");
                                System.out.println("4. Add product to cart. Cart's ID:");
                                System.out.println("5. Get product list from cart. Cart's ID: ");
                                System.out.println("6. Get total value of cart. Cart's ID: ");
                                System.out.println("7. Back to main menu.");

                                ShoppingCart cart;
                                Map productList;
                                BigDecimal cartValue;

                                userInput = Integer.valueOf(scanner.nextLine());
                                switch (userInput) {
                                    case 1:
                                        insertCart();
                                        id = productAndCartService.getLastAddedShoppingCartID();
                                        System.out.println("Shopping cart created, ID: " + id);
                                        break;
                                    case 2:
                                        cart = findCartByID();
                                        if (cart == null) {
                                            System.out.println("Cart does not exist!");
                                            break;
                                        } else {
                                            System.out.println("Search result: " + cart);
                                            break;
                                        }
                                    case 3:
                                        cart = findCartByID();
                                        if (cart != null) {
                                            deleteCartByID(cart);
                                            System.out.println("Cart successfully deleted.");
                                            break;
                                        } else {
                                            System.out.println("Cart doesn't exist!");
                                            break;
                                        }
                                    case 4:
                                        product = findProductByID();
                                        if (product == null) {
                                            System.out.println("Product doesn't exist!");
                                            break;
                                        } else {
                                            cart = findCartByID();
                                            if (cart == null) {
                                                System.out.println("Cart doesn't exist!");
                                                break;
                                            } else {
                                                addProductToCart(product, cart);
                                                System.out.println("Added successfully.");
                                                break;
                                            }
                                        }
                                    case 5:
                                        cart = findCartByID();
                                        if (cart == null) {
                                            System.out.println("Cart doesn't exist!");
                                            break;
                                        } else {
                                            productList = getProductList(cart);
                                            System.out.println("Cart contains: " + productList);
                                            break;
                                        }
                                    case 6:
                                        cart = findCartByID();
                                        if (cart == null) {
                                            System.out.println("Cart doesn't exist!");
                                            break;
                                        } else {
                                            cartValue = getCartValue(cart);
                                            System.out.println("Cart total value: " + cartValue);
                                            break;
                                        }
                                    case 7:
                                        flag = false;
                                }
                            } catch (Exception e) {
                                System.out.println("Wrong value!");
                            }
                        }
                        break;
                    case 4:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Wrong value!");
            }
        }
    }

    private Product createProduct() {
        Product product = new Product();
        validateAndSetProductName(product);
        validateAndSetProductPrice(product);
        validateAndSetProductDiscount(product);
        return product;
    }

    private void insertProduct() {
        productAndCartService.insertProduct(createProduct());
    }

    private Product findProductByID() {
        Product product = new Product();
        SetProductID id = new SetProductID();
        while (product.getId() == null) {
            id.setProductID(product);
        }
        return productAndCartService.findProductByID(product.getId());
    }

    private void validateAndSetProductName(Product product) {
        SetProductName name = new SetProductName();
        boolean isWrong = false;
        while (!isWrong) {
            name.setProductName(product);
            isWrong = productAndCartService.validateProductName(product);
        }
    }

    private void validateAndSetProductPrice(Product product) {
        SetProductPrice price = new SetProductPrice();
        boolean isWrong = false;
        while (!isWrong) {
            price.setProductPrice(product);
            isWrong = productAndCartService.validateProductPrice(product);
        }
    }

    private void validateAndSetProductDiscount(Product product) {
        SetProductDiscount discount = new SetProductDiscount();
        boolean isWrong = false;
        while (!isWrong) {
            discount.setProductDiscount(product);
            isWrong = productAndCartService.validateProductDiscount(product);
        }
    }

    private ShoppingCart createCart() {
        ShoppingCart cart = new ShoppingCart();
        validateAndSetCartName(cart);
        return cart;
    }

    private void insertCart() {
        productAndCartService.insertShoppingCart(createCart());
    }

    private void validateAndSetCartName(ShoppingCart cart) {
        SetShoppingCartName name = new SetShoppingCartName();
        boolean isWrong = false;
        while (!isWrong) {
            name.setShoppingCartName(cart);
            isWrong = productAndCartService.validateCartName(cart);

        }
    }

    private ShoppingCart findCartByID() {
        ShoppingCart cart = new ShoppingCart();
        SetShoppingCartID id = new SetShoppingCartID();
        while (cart.getId() == null) {
            id.setShoppingCartID(cart);
        }
        return productAndCartService.findCartByID(cart.getId());
    }

    private void deleteCartByID(ShoppingCart cart) {
        productAndCartService.deleteShoppingCart(cart);
    }

    private void addProductToCart(Product product, ShoppingCart cart) {
        productAndCartService.addProductToCart(product, cart);
    }

    private Map getProductList(ShoppingCart cart) {
        return productAndCartService.getShoppingCartProductList(cart.getId());
    }

    private BigDecimal getCartValue(ShoppingCart cart) {
        return productAndCartService.getProductListTotalValue(cart);
    }

}
