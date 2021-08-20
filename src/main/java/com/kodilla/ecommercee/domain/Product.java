package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID",unique = true)
    private long id;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "GROUP_ID")
    private Group group;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @NotNull
    @Column(name = "QUANTITY")
    private int quantity;

    @NotNull
    @Column(name = "AVAILABILITY")
    private boolean availability;
}