package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String username;

    @NotNull
    private boolean blocked;

    @NotNull
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "userkey_value")),
            @AttributeOverride(name = "expirationTime", column = @Column(name = "userkey_expiration_time"))
    })
    private UserKey userKey;

    @OneToMany(
            targetEntity = Cart.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Cart> carts = new ArrayList<>();

    @OneToMany(
            targetEntity = Order.class,
            mappedBy = "user",
            cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY
    )
    private List<Order> orders = new ArrayList<>();

    public void addCart(Cart cart) {
        carts.add(cart);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
}
