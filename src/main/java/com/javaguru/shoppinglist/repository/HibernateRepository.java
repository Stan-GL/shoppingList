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
public class HibernateRepository implements CRUD {

    private final SessionFactory sessionFactory;

    @Autowired
    public HibernateRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void insertInRepository(Product product) {
        sessionFactory.getCurrentSession().save(product);
    }

    @Override
    public void insert(ShoppingCart cart) {
        sessionFactory.getCurrentSession().save(cart);
    }

    @Override
    public Product getByID(Product product) {
        return (Product) sessionFactory.getCurrentSession().createCriteria(Product.class)
                .add(Restrictions.eq("productId", product.getProductId()))
                .uniqueResult();
    }

    @Override
    public boolean ifProductExistsByName(Product product) {
        String query = "SELECT p FROM Product p WHERE p.productName='" + product.getProductName() + "'";
        return sessionFactory.getCurrentSession().createQuery(query).list().isEmpty();
    }

    @Override
    public ShoppingCart getByID(ShoppingCart cart) {
        return (ShoppingCart) sessionFactory.getCurrentSession().createCriteria(ShoppingCart.class)
                .add(Restrictions.eq("cartId", cart.getCartId()))
                .uniqueResult();
    }

    @Override
    public void addProductToCart(Product product, ShoppingCart cart) {
        getByID(product).getCartList().add(getByID(cart));
    }

    @Override
    public void deleteProductByID(Product product) {
    }

    @Override
    public void deleteByID(ShoppingCart cart) {
        sessionFactory.getCurrentSession().delete(cart);
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
        return cart.getProductList();
    }

    @Override
    public HashMap<Long, Product> getProductRepository() {
        return null;
    }
}
