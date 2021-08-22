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
    private long id;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "GROUP_ID")
    private Group group;

    @NotNull
    private String name;

    private String description;

    @NotNull
    private int value;


}