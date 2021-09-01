package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.dto.ProductDto;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper extends EntityMapper<Product, ProductDto>{

    @Override
    public Product toEntity(ProductDto productDto) {
        return new Product(
                productDto.getId(),
                productDto.getGroup(),
                productDto.getCart(),
                productDto.getName(),
                productDto.getDescription(),
                productDto.getPrice()
        );
    }

    @Override
    public ProductDto toDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getGroup(),
                product.getCart(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }
}
