package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.ProductService;

import java.util.Scanner;

public class ConsoleUI {

    private ProductService productService = new ProductService();

    public void run() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by id");
                System.out.println("3. Exit");
                Integer userInput = Integer.valueOf(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        try {
                            createProduct();
                            break;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            break;
                        }
                    case 2:
                        try {
                            findProduct();
                            break;
                        } catch (Exception e) {
                            System.out.println("Product does not exist.");
                            break;
                        }
                    case 3:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Wrong value!");
            }
        }
    }

    private Product collectProductProperties() {
        Product product = new Product();
        collectProductName(product);
        collectProductPrice(product);
        collectProductDiscount(product);
        return product;
    }

    private void createProduct() {
        productService.insertProduct(collectProductProperties());
        System.out.println("Result: product was added, ID: " + productService.getLastAddedProductID());
    }

    private Product findProduct() {
        Product product = new Product();
        CatchProductID id = new CatchProductID();
        id.catchUserInput(product);
        Product result = productService.findByID(product.getId());
        System.out.println("Search result: " + result);
        return result;
    }

    private void collectProductPrice(Product product) {
        CatchProductPrice price = new CatchProductPrice();
        price.catchUserInput(product);
        productService.validateProductPrice(product);
    }

    private void collectProductName(Product product) {
        CatchProductName name = new CatchProductName();
        name.catchUserInput(product);
        productService.validateProductName(product);
    }

    private void collectProductDiscount(Product product) {
        CatchProductDiscount discount = new CatchProductDiscount();
        discount.catchUserInput(product);
        productService.validateProductDiscount(product);
    }

}
