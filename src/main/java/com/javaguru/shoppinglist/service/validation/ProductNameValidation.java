package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import java.util.Map;

public class ProductNameValidation implements ValidationRules {

    public boolean validate(Product product) {
        checkNotNull(product);
        if (!product.getName().isEmpty()) {
            if (product.getName().length() < 3 || product.getName().length() > 32) {
                System.out.println("Name must contain 3-32 symbols!");
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public boolean validateIfNameExclusive(Product product, Map<Long, Product> productRepository) {
        checkNotNull(product);
        checkNotNull(productRepository);
        for (Map.Entry<Long, Product> entry : productRepository.entrySet()) {
            if (entry.getValue().getName().equals(product.getName())) {
                System.out.println("Product name already exists, choose another name.");
                return false;
            }
        }
        return true;
    }

}

