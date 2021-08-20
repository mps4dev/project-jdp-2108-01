package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    private Group group;
}
