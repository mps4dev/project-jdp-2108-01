package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.dto.ProductDto;
import com.kodilla.ecommercee.exception.CreatingObjectWithIdException;
import com.kodilla.ecommercee.exception.EntityNotFoundException;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductService {

    private final ProductMapper mapper;
    private final ProductRepository repository;

    public List<ProductDto> getAll() {
        return mapper.toDtoList(repository.findAll());
    }

    public ProductDto getById(final long id) throws EntityNotFoundException {
        return repository.findById(id).map(mapper::toDto).orElseThrow(() -> new EntityNotFoundException(Product.class, id));
    }

    @Transactional
    public ProductDto create(final ProductDto productDto) throws CreatingObjectWithIdException {
        if (productDto.getId() != 0) throw new CreatingObjectWithIdException(Product.class, productDto.getId());
        return saveAndMapToDto(productDto);
    }

    @Transactional
    public ProductDto update(final ProductDto productDto) throws EntityNotFoundException {
        repository.findById(productDto.getId()).orElseThrow(() -> new EntityNotFoundException(Product.class, productDto.getId()));
        return saveAndMapToDto(productDto);
    }

    private ProductDto saveAndMapToDto(final ProductDto productDto) {
        Product product = repository.save(mapper.toEntity(productDto));
        return mapper.toDto(product);
    }

    @Transactional
    public void delete(final long id) throws EntityNotFoundException {
        repository.findById(id).orElseThrow(() -> new EntityNotFoundException(Product.class, id));
        repository.deleteById(id);
    }
}
