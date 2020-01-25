package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.database.Category;
import com.javaguru.shoppinglist.database.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ShoppingListApplication {

    public static void main(String[] args) {
        Map<Long, Product> productRepository = new HashMap<>();
        Long productIdSequence = 0L;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by id");
                System.out.println("3. Exit");
                Integer userInput = Integer.valueOf(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        System.out.println("Enter product name: ");
                        String name = scanner.nextLine();
                        validateProductName(name);
                        System.out.println("Enter product price: ");
                        BigDecimal price = new BigDecimal(scanner.nextLine());
                        validateProductPrice(price);
                        System.out.println("Enter product discount in %: ");
                        BigDecimal discount = new BigDecimal((scanner.nextLine()));
                        validateProductDiscount(discount);
                        System.out.println("Enter product category: ");
                        String category = scanner.nextLine();
                        validateProductCategory(category);
                        System.out.println("Enter product description: ");
                        String description = scanner.nextLine();
                        Product product = new Product();
                        product.setDiscount(discount);
                        product.setName(name);
                        product.setPrice(price);
                        product.setId(productIdSequence);
                        product.setCategory(Category.valueOf(category));
                        product.setDescription(description);
                        productRepository.put(productIdSequence, product);
                        productIdSequence++;
                        System.out.println("Result: new product was added, ID " + product.getId());
                        break;
                    case 2:
                        System.out.println("Enter product id: ");
                        long id = scanner.nextLong();
                        Product findProductResult = productRepository.get(id);
                        System.out.println(findProductResult);
                        break;
                    case 3:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
            }
        }
    }

    private static boolean validateProductDiscount(BigDecimal discount) {
        BigDecimal max = new BigDecimal("100");
        BigDecimal min = new BigDecimal("0");
        if ((discount.compareTo(max) == 1) || (discount.compareTo(min)) == -1) {
            throw new IllegalArgumentException();
        } else {
            return true;
        }
    }

    private static void validateProductCategory(String category) {
        Category.valueOf(category);
    }

    private static boolean validateProductName(String name) {
        if (name.length() < 3 || name.length() > 32) {
            throw new IllegalArgumentException();
        } else {
            return true;
        }
    }

    private static boolean validateProductPrice(BigDecimal price) {
        BigDecimal var = new BigDecimal("0");
        if ((price.compareTo(var) == -1) || (price.compareTo(var) == 0)) {
            throw new IllegalArgumentException();
        } else {
            return true;
        }
    }
}
