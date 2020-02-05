package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {

    private Map<Long, Product> productRepository = new HashMap<>();
    private Long productIdSequence = 0L;

    public Product insert(Product product) {
        product.setId(productIdSequence);
        productRepository.put(productIdSequence, product);
        productIdSequence++;
        return product;
    }

    public Product findByID(Long productID) {
        if (!productRepository.containsKey(productID)) {
            throw new NullPointerException();
        } else {
            return productRepository.get(productID);
        }
    }

    public boolean findByName(String name) {
        for (Map.Entry<Long, Product> entry : productRepository.entrySet()) {
            if (entry.getValue().getName().equals(name)) {
                return false;
            }
        }
        return true;
    }

}
