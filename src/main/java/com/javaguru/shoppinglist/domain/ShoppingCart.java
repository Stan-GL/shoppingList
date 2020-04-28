package com.javaguru.shoppinglist.domain;


import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "shopping_carts")
public class ShoppingCart {

    @Id
    @Column(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cartId;

    @Column(name = "cart_name")
    private String cartName;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "shopping_cart_id")
    private Set<ShoppingCartProductList> productLists;

    public String getCartName() {
        return cartName;
    }

    public void setCartName(String name) {
        this.cartName = name;
    }

    public void setCartId(Long id) {
        this.cartId = id;
    }

    public Long getCartId() {
        return cartId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return Objects.equals(cartId, that.cartId) &&
                Objects.equals(cartName, that.cartName) &&
                Objects.equals(productLists, that.productLists);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId, cartName, productLists);
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + cartId +
                ", name='" + cartName + '\'' +
                ", productList=" + productLists +
                '}';
    }

}
