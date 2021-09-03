package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "products")
public class Product {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @NonNull
    @JoinColumn(name = "group_id")
    private Group group;

    @NonNull
    private String name;

    private String description;

    @NotNull
    private int price;
}
