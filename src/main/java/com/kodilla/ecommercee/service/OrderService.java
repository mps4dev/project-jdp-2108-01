package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.exception.CreatingObjectWithIdException;
import com.kodilla.ecommercee.exception.EntityNotFoundException;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class OrderService {

    private final OrderMapper mapper;
    private final OrderRepository repository;

    public List<OrderDto> getAll() {
        return mapper.toDtoList(repository.findAll());
    }

    public OrderDto getById(long id) throws EntityNotFoundException {
        return repository.findById(id).map(mapper::toDto).orElseThrow(() -> new EntityNotFoundException(Order.class, id));
    }

    @Transactional
    public OrderDto create(final OrderDto orderDto) throws CreatingObjectWithIdException {
        if (orderDto.getId() != 0) throw new CreatingObjectWithIdException(Order.class, orderDto.getId());

        return saveAndMapToDto(orderDto);
    }

    @Transactional
    public void delete(final long id) throws EntityNotFoundException {
        repository.findById(id).orElseThrow(() -> new EntityNotFoundException(Order.class, id));
        repository.deleteById(id);
    }

    @Transactional
    public OrderDto update(final OrderDto orderDto) throws EntityNotFoundException {
        repository.findById(orderDto.getId()).orElseThrow(() -> new EntityNotFoundException(Order.class, orderDto.getId()));
        return saveAndMapToDto(orderDto);
    }

    private OrderDto saveAndMapToDto(final OrderDto orderDto) {
        Order order = repository.save(mapper.toEntity(orderDto));
        return mapper.toDto(order);
    }
}