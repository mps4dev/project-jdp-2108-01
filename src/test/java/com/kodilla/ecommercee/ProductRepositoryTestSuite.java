package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;
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

    Group group = new Group();
    Product product = new Product();
    Product product2 = new Product();

    public void createData() {
        group.setName("test group");
        product.setName("test product");
        product.setGroup(group);
        product.setPrice(11);
        group.getProducts().add(product);

        product2.setName("test product nr 2");
        product2.setGroup(group);
        product2.setPrice(22);
        group.getProducts().add(product2);
    }

    public void deleteData() {
        try {
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
        assertNotEquals(0, group.getId());
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
        deleteData();

        //Then
        assertEquals(Optional.empty(), productRepository.findById(product.getId()));
    }

    @Test
    public void testProductRepositoryUpdate() {
        //Given
        createData();

        //When
        groupRepository.save(group);
        String updatedName = "updated product";
        product.setName(updatedName);
        productRepository.save(product);

        //Then
        assertEquals(updatedName, product.getName());

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
        assert retrievedProduct.orElse(null) != null;
        assertEquals("test product", retrievedProduct.get().getName());

        //CleanUp
        deleteData();
    }

    @Test
    public void testProductRepositoryGetAll() {
        //Given
        createData();

        //When
        groupRepository.save(group);
        List<Product> retrievedProductList = (List<Product>) productRepository.findAll();

        //Then
        assertTrue(retrievedProductList.size() >= 2);

        //CleanUp
        deleteData();
    }

}
