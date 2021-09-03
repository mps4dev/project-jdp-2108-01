package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        group = new Group("test group");
        product = new Product(group, "test product");
        group.getProducts().add(product);

        product2 = new Product(group, "test product nr2");
        group.getProducts().add(product2);
    }

    public void deleteData() {
        try {
            productRepository.deleteById(product.getId());
            productRepository.deleteById(product2.getId());
            groupRepository.deleteById(group.getId());
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
        String updatedName = "updated product";
        product = new Product(group, updatedName);
        productRepository.save(product);

        //Then
        assertEquals(updatedName, productRepository.findById(product.getId()).orElse(new Product()).getName());

        //CleanUp
        deleteData();
    }

    @Test
    public void testProductRepositoryGet() {
        //Given
        createData();

        //When
        groupRepository.save(group);
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
        List<Product> retrievedProductList = productRepository.findAll();

        //Then
        assertEquals(2, retrievedProductList.size());

        //CleanUp
        deleteData();
    }

}
