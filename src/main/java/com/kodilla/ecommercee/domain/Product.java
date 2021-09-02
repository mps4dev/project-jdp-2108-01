package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "products")
public class Product {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "group_id")
    private Group group;

    @NotNull
    private String name;

    private String description;

    @NotNull
    private int price;
}
