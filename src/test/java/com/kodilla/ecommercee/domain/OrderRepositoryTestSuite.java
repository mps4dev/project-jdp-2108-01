package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class OrderRepositoryTestSuite {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    private User user;
    private User user2;
    private User user3;
    private Cart cart;
    private Cart cart2;
    private Cart cart3;
    private Order order;
    private Order order2;


    private void createData() {
        user = new User(0, "testUser", false, new UserKey(), new ArrayList<>(), new ArrayList<>());
        cart = new Cart(0, new ArrayList<>(), user);
        order = new Order(0, user, cart);
        user.addCart(cart);
        user.addOrder(order);
    }

    private void createAdditionalData() {
        user2 = new User(0, "testUser nr2", false, new UserKey(), new ArrayList<>(), new ArrayList<>());
        cart2 = new Cart(0, new ArrayList<>(), user2);
        order2 = new Order(0, user2, cart2);
        user2.addCart(cart2);
        user2.addOrder(order2);
    }

    private void deleteData() {
        orderRepository.delete(order);
        cartRepository.delete(cart);
        userRepository.delete(user);
    }

    @Test
    public void testOrderRepositorySave() {
        //Given
        createData();

        userRepository.save(user);
        cartRepository.save(cart);

        //When
        orderRepository.save(order);

        //Then
        assertNotEquals(0, order.getId());

        //Clean-up
        deleteData();
    }

    @Test
    public void testOrderRepositoryDelete() {
        //Given
        createData();

        userRepository.save(user);
        cartRepository.save(cart);
        orderRepository.save(order);

        //When
        orderRepository.deleteById(order.getId());

        //Then
        assertFalse(orderRepository.findById(order.getId()).isPresent());
        assertEquals(0, orderRepository.findAll().size());

        //Clean-up
        cartRepository.deleteById(cart.getId());
        userRepository.deleteById(user.getId());
    }

    @Test
    public void testOrderRepositoryUpdate() {
        //Given
        createData();

        userRepository.save(user);
        cartRepository.save(cart);
        orderRepository.save(order);

        user3 = new User(0, "testUser nr3", user.isBlocked(), user.getUserKey(), new ArrayList<>(), new ArrayList<>());
        cart3 = new Cart(0, new ArrayList<>(), user3);
        order.setUser(user3);
        order.setCart(cart3);
        user3.addCart(cart3);
        user3.addOrder(order);

        userRepository.save(user3);
        cartRepository.save(cart3);

        //When
        Order updatedOrder = orderRepository.save(order);

        //Then
        assertEquals( user3.getId(), updatedOrder.getUser().getId());

        //Clean-up
        deleteData();
        cartRepository.deleteById(cart3.getId());
        userRepository.deleteById(user3.getId());
    }

    @Test
    public void testOrderRepositoryGet() {
        //Given
        createData();

        userRepository.save(user);
        cartRepository.save(cart);
        orderRepository.save(order);

        //When
        Optional<Order> retrievedOrder = orderRepository.findById(order.getId());

        //Then
        assertTrue(retrievedOrder.isPresent());
        assertEquals( "testUser", retrievedOrder.orElse(new Order()).getUser().getUsername());

        //Clean-up
        deleteData();
    }

    @Test
    public void testOrderRepositoryGetAll() {
        //Given
        createData();
        createAdditionalData();

        userRepository.save(user);
        cartRepository.save(cart);
        orderRepository.save(order);

        userRepository.save(user2);
        cartRepository.save(cart2);
        orderRepository.save(order2);

        //When
        List<Order> retrievedOrderList = orderRepository.findAll();

        //Then
        assertEquals(2, retrievedOrderList.size());

        //Clean-up
        deleteData();
    }
}
