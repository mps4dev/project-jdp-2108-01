package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartRepositoryTestSuite {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderRepository orderRepository;

    private Cart cart;
    private User user;
    private Order order;

    private void createData() {
        user = new User(0, "test user", false, 1234, new ArrayList<>(), new ArrayList<>());
        cart = new Cart(0, new ArrayList<>(), user);
    }

    private void deleteData() {
            cartRepository.delete(cart);
    }

    private void prepareDataAndSave() {
        createData();
        cartRepository.save(cart);
    }

    @Test
    public void testCartRepositorySave() {
        //Given
        createData();

        //When
        cartRepository.save(cart);

        //Then
        assertNotEquals(0, cart.getId());

        //CleanUp
        deleteData();
    }

    @Test
    public void testCartRepositoryGet() {
        //Given
        prepareDataAndSave();

        //When
        Optional<Cart> result = cartRepository.findById(cart.getId());

        //Then
        assertTrue(result.isPresent());
        assertEquals("test user", result.orElse(new Cart()).getUser().getUsername());

        //CleanUp
        deleteData();
    }

    @Test
    public void testCartRepositoryUpdate() {
        //Given
        prepareDataAndSave();

        //When
        String updatedUsername = "updated User";
        user = new User(user.getId(),updatedUsername, user.isStatus(), user.getUserKey(), user.getCarts(), user.getOrders());

        System.out.println(user.getUsername());
        cart = new Cart(1, new ArrayList<>(), user);
        userRepository.save(user);
        Cart updatedCart = cartRepository.save(cart);

        //Then
        assertEquals(updatedUsername, updatedCart.getUser().getUsername());

        //CleanUp
        deleteData();
    }

    @Test
    public void testCreateOrder() {
        //Given
        prepareDataAndSave();

        //When
        order = new Order(0, cart.getUser(), cart);
        userRepository.save(user);
        orderRepository.save(order);
        Optional<Order> resultById = orderRepository.findById(order.getId());

        //Then
        assertEquals(resultById, order);

        //CleanUp
        deleteData();
    }

    @Test
    public void testCartRepositoryDelete() {
        //Given
       prepareDataAndSave();

       //When
        cartRepository.deleteById(cart.getId());
        Optional<Cart> resultById = cartRepository.findById(cart.getId());
        List<Cart> result = cartRepository.findAll();

        //Then
        assertFalse(resultById.isPresent());
        assertEquals(0,result.size());
    }


}
