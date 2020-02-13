package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

import java.util.Map;

public class MainRepository implements CRUD {

    private Map<Long, Product> productRepository;
    private Long productIdSequence = 0L;
    private Map<Long, ShoppingCart> shoppingCartRepository;
    private Long cartIdSequence = 0L;

    public MainRepository(Map<Long, Product> productRepository, Map<Long, ShoppingCart> shoppingCartRepository) {
        this.productRepository = productRepository;
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    public void insertProduct(Product product) {
        product.setId(productIdSequence);
        productRepository.put(productIdSequence, product);
        productIdSequence++;
    }

    @Override
    public void insertShoppingCart(ShoppingCart cart) {
        cart.setId(cartIdSequence);
        shoppingCartRepository.put(cartIdSequence, cart);
        cartIdSequence++;
    }

    @Override
    public Product getProductByID(Product product) {
        return productRepository.get(product.getId());
    }

    @Override
    public ShoppingCart getShoppingCartByID(ShoppingCart cart) {
        return shoppingCartRepository.get(cart.getId());
    }

    @Override
    public void deleteProductByID(Product product) {
        productRepository.remove(product.getId());
    }

    @Override
    public void deleteShoppingCartByID(ShoppingCart cart) {
        shoppingCartRepository.remove(cart.getId());
    }

}
