package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.dto.ProductDto;
import com.kodilla.ecommercee.repository.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProductMapper extends EntityMapper<Product, ProductDto> {

    GroupRepository repository;

    @Override
    public Product toEntity(ProductDto productDto) {
        return new Product(
                productDto.getId(),
                repository.findById(productDto.getGroupId()).orElse(null),
                productDto.getName(),
                productDto.getDescription(),
                productDto.getPrice()
        );
    }

    @Override
    public ProductDto toDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getGroup().getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }
}
