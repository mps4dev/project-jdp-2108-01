package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class UserRepositoryTestSuite {

    @Autowired
    UserRepository repository;

    private User user;
    private Cart cart;
    private Order order;

    @BeforeEach
    public void prepareData() {
        user = new User(0, "testUser", false, 123456789, new ArrayList<>(), new ArrayList<>());
        cart = new Cart(0, user); //to do
    }
}
