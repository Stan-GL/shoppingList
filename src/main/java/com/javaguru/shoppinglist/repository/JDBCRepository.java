package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
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
    public void insertProduct(Product product) {
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
    public void insertShoppingCart(ShoppingCart cart) {
        System.out.println("Inserted NULL");

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
    public boolean ifProductExistsByName(Product product) {
        String query = " Select * from products where product_name = ?";
        List<Product> result = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Product.class), product.getProductName());
        return result.isEmpty();
    }

    @Override
    public ShoppingCart getShoppingCartByID(ShoppingCart cart) {
        return null;
    }

    @Override
    public void deleteProductByID(Product product) {

    }

    @Override
    public void deleteShoppingCartByID(ShoppingCart cart) {

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
    public HashMap<Long, Product> getProductRepository() {
        return null;
    }
}
