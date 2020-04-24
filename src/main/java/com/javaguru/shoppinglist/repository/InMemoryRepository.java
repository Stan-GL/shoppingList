package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Profile("inmemory")
public class InMemoryRepository implements CRUD {

    private final HashMap<Long, Product> productRepository = new HashMap<>();
    private Long productIdSequence = 0L;
    private final Map<Long, ShoppingCart> shoppingCartRepository = new HashMap<>();
    private Long cartIdSequence = 0L;

    @Override
    public void insertProduct(Product product) {
        productIdSequence++;
        product.setProductId(productIdSequence);
        productRepository.put(productIdSequence, product);
    }

    @Override
    public void insertShoppingCart(ShoppingCart cart) {
        cartIdSequence++;
        cart.setId(cartIdSequence);
        shoppingCartRepository.put(cartIdSequence, cart);
    }

    @Override
    public Product getProductByID(Product product) {
        return productRepository.get(product.getProductId());
    }

    @Override
    public boolean ifProductExistsByName(Product product) {
        return false;
    }

    @Override
    public ShoppingCart getShoppingCartByID(ShoppingCart cart) {
        return shoppingCartRepository.get(cart.getId());
    }

    @Override
    public void deleteProductByID(Product product) {
        productRepository.remove(product.getProductId());
    }

    @Override
    public void deleteShoppingCartByID(ShoppingCart cart) {
        shoppingCartRepository.remove(cart.getId());
    }

    @Override
    public Long getProductIdSequence() {
        return productIdSequence;
    }

    @Override
    public Long getCartIdSequence() {
        return cartIdSequence;
    }

    @Override
    public HashMap<Long, Product> getProductRepository() {
        return productRepository;
    }
}
