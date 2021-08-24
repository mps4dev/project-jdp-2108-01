package com.kodilla.ecommercee.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Order {

    @Id
    private long id;
}
