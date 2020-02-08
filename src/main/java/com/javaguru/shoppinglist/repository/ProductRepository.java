package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {

    private Map<Long, Product> productRepository = new HashMap<>();
    private Long productIdSequence = 0L;
    private Map<Long, ShoppingCart> shoppingCartRepository = new HashMap<>();
    private Long cartIdSequence = 0L;

    public void insertProduct(Product product) {
        product.setId(productIdSequence);
        productRepository.put(productIdSequence, product);
        productIdSequence++;
    }

    public void insertShoppingCart(ShoppingCart cart) {
        cart.setId(cartIdSequence);
        shoppingCartRepository.put(cartIdSequence, cart);
        cartIdSequence++;
    }

    public ShoppingCart findShoppingCart(Long cartID) {
        return shoppingCartRepository.get(cartID);
    }

    public void deleteShoppingCart(ShoppingCart cart) {
        shoppingCartRepository.remove(cart.getId());
    }

    public Product findProductByID(Long productID) {
        return productRepository.get(productID);
    }

    public Map<Long, Product> getProductRepository() {
        return productRepository;
    }

    public Map<Long, ShoppingCart> getShoppingCartRepository() {
        return shoppingCartRepository;
    }
}
