package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;

@Repository
@Profile("hibernate")
@Transactional
public class HibernateProductRepository implements CRUD {

    private final SessionFactory sessionFactory;

    @Autowired
    public HibernateProductRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void insertProductInRepository(Product product) {
        sessionFactory.getCurrentSession().save(product);
    }

    @Override
    public void addProductToCart(Product product, ShoppingCart cart) {

    }

    @Override
    public void insertShoppingCart(ShoppingCart cart) {
        sessionFactory.getCurrentSession().save(cart);
    }

    @Override
    public Product getProductByID(Product product) {
        return (Product) sessionFactory.getCurrentSession().createCriteria(Product.class)
                .add(Restrictions.eq("product_id", product.getProductId()))
                .uniqueResult();
    }

    @Override
    public boolean ifProductExistsByName(Product product) {
        String query = " Select " +
                " IF count(*) > 0, 1, 0 " +
                " from products where product_name '" + product.getProductName() + "'";
        return (boolean) sessionFactory.getCurrentSession().createQuery(query)
                .setMaxResults(1)
                .uniqueResult();
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
    public List<Product> getShoppingCartProductList(ShoppingCart cart) {
        return null;
    }

    @Override
    public HashMap<Long, Product> getProductRepository() {
        return null;
    }
}
