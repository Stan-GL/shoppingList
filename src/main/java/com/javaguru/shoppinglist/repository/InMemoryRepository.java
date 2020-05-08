package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Profile("inmemory")
public class InMemoryRepository implements CRUD {

    private final HashMap<Long, Product> productRepository = new HashMap<>();
    private Long productIdSequence = 0L;
    private final Map<Long, ShoppingCart> shoppingCartRepository = new HashMap<>();
    private Long cartIdSequence = 0L;

    @Override
    public void insertProductInRepository(Product product) {
        productIdSequence++;
        product.setProductId(productIdSequence);
        productRepository.put(productIdSequence, product);
    }

    @Override
    public void addProductToCart(Product product, ShoppingCart cart) {

    }

    @Override
    public void insertShoppingCart(ShoppingCart cart) {
        cartIdSequence++;
        cart.setCartId(cartIdSequence);
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
        return shoppingCartRepository.get(cart.getCartId());
    }

    @Override
    public void deleteProductByID(Product product) {
        productRepository.remove(product.getProductId());
    }

    @Override
    public void deleteShoppingCartByID(ShoppingCart cart) {
        shoppingCartRepository.remove(cart.getCartId());
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
    public List<Product> getShoppingCartProductList(ShoppingCart cart) {
        return null;
    }

    @Override
    public HashMap<Long, Product> getProductRepository() {
        return productRepository;
    }
}
