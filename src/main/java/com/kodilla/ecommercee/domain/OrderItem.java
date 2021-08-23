package com.kodilla.ecommercee.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderItem {

    @Id
    private long id;

    @ManyToOne
    private Cart cart;
}
