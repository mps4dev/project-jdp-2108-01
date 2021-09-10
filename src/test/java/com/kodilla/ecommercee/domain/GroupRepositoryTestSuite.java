package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupRepositoryTestSuite {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private GroupRepository groupRepository;

    private Group group1;
    private Group group2;
    private Product product1;
    private Product product2;
    private Product product3;
    private Product product4;

    @Test
    public void testGroupRepositorySave() {
        //Given
        createData();

        //When
        Group result = groupRepository.save(group1);

        //Then
        assertEquals(1, result.getId());

        //CleanUp
        deleteData();
    }

    @Test
    public void testGroupRepositoryDelete() {
        //Given
        createData();
        groupRepository.save(group1);
        groupRepository.save(group2);

        //When
        groupRepository.deleteById(group1.getId());

        //Then
        assertEquals(Optional.empty(), groupRepository.findById(group1.getId()));
        assertNotEquals(Optional.empty(), groupRepository.findById(group2.getId()));

        //CleanUp
        try {
            groupRepository.deleteById(group2.getId());
        } catch (Exception e) {
            System.out.println("Something went wrong! Error: " + e);
        }
    }

    @Test
    public void testGroupRepositoryUpdate() {
        //Given
        createData();

        //When
        groupRepository.save(group1);
        String updatedName = "updated group";
        group1 = new Group(group1.getId(), updatedName, group1.getProducts());
        Group updatedGroup = groupRepository.save(group1);

        //Then
        assertEquals(updatedName, updatedGroup.getName());

        //CleanUp
        deleteData();
    }

    @Test
    public void testGroupRepositoryGet() {
        //Given
        createData();

        //When
        groupRepository.save(group1);
        Optional<Group> retrievedGroup = groupRepository.findById(group1.getId());

        //Then
        assertTrue(retrievedGroup.isPresent());
        assertEquals("test group1", retrievedGroup.orElse(new Group()).getName());

        //CleanUp
        deleteData();
    }

    @Test
    public void testGroupRepositoryGetAll() {
        //Given
        createData();

        //When
        groupRepository.save(group1);
        groupRepository.save(group2);
        List<Group> retrievedGroupList = groupRepository.findAll();

        //Then
        assertEquals(2, retrievedGroupList.size());

        //CleanUp
        deleteData();
    }

    private void createData() {
        group1 = new Group(0, "test group1", new ArrayList<>());
        product1 = new Product(0, group1, "test product1", "description1", 10);
        product2 = new Product(0, group1, "test product2", "description2", 11);

        group1.getProducts().add(product1);
        group1.getProducts().add(product2);

        group2 = new Group(0, "test group2", new ArrayList<>());
        product3 = new Product(0, group2, "test product3", "description3", 12);
        product4 = new Product(0, group2, "test product4", "description4", 13);

        group2.getProducts().add(product3);
        group2.getProducts().add(product4);
    }

    private void deleteData() {
        try {
            productRepository.delete(product1);
            productRepository.delete(product2);
            groupRepository.delete(group1);
            productRepository.delete(product3);
            productRepository.delete(product4);
            groupRepository.delete(group2);
        } catch (Exception e) {
            System.out.println("Something went wrong! Error: " + e);
        }
    }
}
