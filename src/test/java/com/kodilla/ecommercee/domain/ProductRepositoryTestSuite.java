package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;

import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTestSuite {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    GroupRepository groupRepository;

    private Group group;
    private Product product;
    private Product product2;

    public void createData() {
        group = new Group(0, "test group", new ArrayList<>());
        product = new Product(0, group, "test product", "", 11);
        group.getProducts().add(product);

        product2 = new Product(0, group, "test product nr2", "", 12);
        group.getProducts().add(product2);
    }

    public void deleteData() {
        try {
            productRepository.delete(product);
            productRepository.delete(product2);
            groupRepository.delete(group);
        } catch (Exception e) {
            System.out.println("Something went wrong! Error: " + e);
        }
    }

    @Test
    public void testProductRepositorySave() {
        //Given
        createData();

        //When
        groupRepository.save(group);
        productRepository.save(product);
        productRepository.save(product2);

        //Then
        assertNotEquals(0, product2.getId());
        assertNotEquals(0, product.getId());

        //CleanUp
        deleteData();
    }

    @Test
    public void testProductRepositoryDelete() {
        //Given
        createData();

        //When
        groupRepository.save(group);
        productRepository.save(product);
        productRepository.save(product2);

        try {
            productRepository.deleteById(product.getId());
        } catch (Exception e) {
            System.out.println("Something went wrong! Error: " + e);
        }

        //Then
        assertEquals(Optional.empty(), productRepository.findById(product.getId()));
        assertNotEquals(Optional.empty(), productRepository.findById(product2.getId()));

        //CleanUp
        try {
            productRepository.deleteById(product2.getId());
            groupRepository.deleteById(group.getId());
        } catch (Exception e) {
            System.out.println("Something went wrong! Error: " + e);
        }
    }

    @Test
    public void testProductRepositoryUpdate() {
        //Given
        createData();

        //When
        groupRepository.save(group);
        productRepository.save(product);
        productRepository.save(product2);
        String updatedName = "updated product";
        product = new Product(product.getId(), product.getGroup(), updatedName, product.getDescription(), product.getPrice());
        Product updatedProduct = productRepository.save(product);

        //Then
        assertEquals(updatedName, updatedProduct.getName());

        //CleanUp
        deleteData();
    }

    @Test
    public void testProductRepositoryGet() {
        //Given
        createData();

        //When
        groupRepository.save(group);
        productRepository.save(product);
        productRepository.save(product2);
        Optional<Product> retrievedProduct = productRepository.findById(product.getId());

        //Then
        assertTrue(retrievedProduct.isPresent());
        assertEquals("test product", retrievedProduct.orElse(new Product()).getName());
        //CleanUp
        deleteData();
    }

    @Test
    public void testProductRepositoryGetAll() {
        //Given
        createData();

        //When
        groupRepository.save(group);
        productRepository.save(product);
        productRepository.save(product2);
        List<Product> retrievedProductList = productRepository.findAll();

        //Then
        assertEquals(2, retrievedProductList.size());

        //CleanUp
        deleteData();
    }

}
