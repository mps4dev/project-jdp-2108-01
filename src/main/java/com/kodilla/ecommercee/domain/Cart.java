package com.kodilla.ecommercee.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Entity
public class Cart {

    @Id
    private long id;

    @ManyToOne
    private User user;
}
