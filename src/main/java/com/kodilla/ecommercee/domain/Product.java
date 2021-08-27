package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "GROUP_ID")
    private Group group;

    @NotNull
    private String name;

    private String description;

    @NotNull
    private int price;
}
