package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.ProductService;

import java.math.BigDecimal;
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
                            productService.insertProduct(createProduct());
                            System.out.println("Result: product was added, ID: " + productService.getLastAddedProductID());
                            break;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            break;
                        }
                    case 2:
                        try {
                            System.out.println(productService.findByID(catchProductID()));
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

    public Long catchProductID() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product ID [digits only]: ");
        long id = scanner.nextLong();
        productService.findByID(id);
        return id;
    }

    public String catchProductName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name [3-32 symbols]: ");
        String name = scanner.nextLine();
        productService.validateProductName(name);
        return name;
    }

    public BigDecimal catchProductPrice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product price: ");
        BigDecimal price = scanner.nextBigDecimal();
        productService.validateProductPrice(price);
        return price;
    }

    public BigDecimal catchProductDiscount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product discount [%]: ");
        BigDecimal discount = scanner.nextBigDecimal();
        productService.validateProductDiscount(discount);
        return discount;
    }

    public Product createProduct() {
        Product product = new Product();
        product.setName(catchProductName());
        product.setPrice(catchProductPrice());
        product.setDiscount(catchProductDiscount());
        return product;
    }
}
