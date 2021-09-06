package com.kodilla.ecommercee.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cart {

    @Id
    private long id;

    @ManyToOne
    private User user;
}
