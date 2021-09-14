package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTestSuite {

    @Autowired
    private UserRepository userRepository;

    private User user;

    @Test
    public void shouldReturnAllUsersFromRepository() {
        //Given
        prepareDataAndSave();

        //When
        List<User> result = userRepository.findAll();

        //Then
        assertEquals(1, result.size());

        //CleanUp
        deleteData();
    }

    @Test
    public void shouldReturnUserWithExactIdFromRepository() {
        //Given
        prepareDataAndSave();

        //When
        Optional<User> result = userRepository.findById(user.getId());

        //Then
        assertTrue(result.isPresent());
        assertEquals("testUser", result.orElse(new User()).getUsername());

        //CleanUp
        deleteData();
    }

    @Test
    public void shouldSaveUserToRepositoryAndGrantCorrectId() {
        //Given
        prepareData();

        //When
        userRepository.save(user);

        //Then
        assertNotEquals(0, user.getId());

        //CleanUp
        deleteData();
    }

    @Test
    public void shouldUpdateUserInRepository() {
        //Given
        prepareDataAndSave();

        //When
        String updatedName = "updatedUser";
        user = new User(user.getId(), updatedName, user.isBlocked(), user.getUserKey(), user.getCarts(), user.getOrders());
        User result = userRepository.save(user);

        //Then
        assertEquals(updatedName, result.getUsername());
        assertNotEquals(0, result.getId());

        //CleanUp
        deleteData();
    }

    @Test
    public void shouldDeleteUserFromRepository() {
        //Given
        prepareDataAndSave();

        //When
        userRepository.deleteById(user.getId());
        Optional<User> resultByName = userRepository.findByUsername(user.getUsername());
        List<User> result = userRepository.findAll();

        //Then
        assertFalse(resultByName.isPresent());
        assertEquals(0, result.size());
    }

    private void prepareData() {
        user = new User(0, "testUser", false, new UserKey(), new ArrayList<>(), new ArrayList<>());
    }

    private void prepareDataAndSave() {
        prepareData();
        userRepository.save(user);
    }

    private void deleteData() {
        userRepository.deleteById(user.getId());
    }
}
