package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

@Component
@Profile("JDBC")
public class JDBCRepository implements CRUD {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertProductInRepository(Product product) {
        String query = "Insert into products (product_name, product_price, product_discount) values (?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setBigDecimal(2, product.getProductPrice());
            preparedStatement.setBigDecimal(3, product.getProductDiscount());
            return preparedStatement;
        }, keyHolder);
        product.setProductId(keyHolder.getKey().longValue());
    }

    @Override
    public void addProductToCart(Product product, ShoppingCart cart) {
        String query = "Insert into shopping_cart_product_list (product_id, shopping_cart_id) values (?,?)";

        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, product.getProductId());
            preparedStatement.setLong(2, cart.getCartId());
            return preparedStatement;
        });
    }

    @Override
    public void insertShoppingCart(ShoppingCart cart) {
        String query = "Insert into shopping_carts (cart_name) values (?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, cart.getCartName());
            return preparedStatement;
        }, keyHolder);
        cart.setCartId(keyHolder.getKey().longValue());
    }

    @Override
    public Product getProductByID(Product product) {
        String query = " Select * from products where product_id = ?";
        List<Product> products = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Product.class), product.getProductId());
        if (products.isEmpty())
            return null;
        return products.get(0);
    }

    @Override
    public ShoppingCart getShoppingCartByID(ShoppingCart cart) {
        String query = " Select * from shopping_carts where cart_id = ?";
        List<ShoppingCart> carts = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(ShoppingCart.class), cart.getCartId());
        if (carts.isEmpty())
            return null;
        return carts.get(0);
    }

    @Override
    public boolean ifProductExistsByName(Product product) {
        String query = " Select * from products where product_name = ?";
        List<Product> result = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Product.class), product.getProductName());
        return result.isEmpty();
    }

    @Override
    public void deleteProductByID(Product product) {

    }

    @Override
    public void deleteShoppingCartByID(ShoppingCart cart) {
        String query = "Delete from shopping_carts where cart_id = ?";
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, cart.getCartId());
            return preparedStatement;
        });
    }

    @Override
    public Long getProductIdSequence() {
        return null;
    }

    @Override
    public Long getCartIdSequence() {
        return null;
    }

    @Override
    public List<Product> getShoppingCartProductList(ShoppingCart cart) {
        String query = " Select * from products where products.product_id IN (select product_id from shopping_cart_product_list where shopping_cart_id = ?)";
        List<Product> productList = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Product.class), cart.getCartId());
        if (productList.isEmpty())
            return null;
        return productList;
    }

    @Override
    public HashMap<Long, Product> getProductRepository() {
        return null;
    }
}
