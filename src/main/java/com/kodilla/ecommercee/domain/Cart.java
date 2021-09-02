package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "carts")
public class Cart {

    @Id
    @GeneratedValue
    private long id;

    @ManyToMany
    @JoinColumn(name = "product_id")
    private List<Product> product = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
