package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.domain.Product;

import java.util.Map;

public class ProductNameValidationRule implements ValidationRules<Product> {

    private Map<Long, Product> productRepository;

    public ProductNameValidationRule(Map<Long, Product> productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public boolean validate(Product product) {
        checkNotNull(product);
        int name = product.getName().replaceAll(" ", "").length();
        if (name < 3 || name > 32) {
            System.out.println("Name must contain 3-32 symbols!");
            return false;
        } else {
            return validateExclusiveness(product, productRepository);
        }
    }

    private boolean validateExclusiveness(Product product, Map<Long, Product> productRepository) {
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

    private void checkNotNull(Map<Long, Product> productRepository) {
        if (productRepository == null) {
            throw new NullPointerException("Object doesn't exist!");
        }
    }

}

