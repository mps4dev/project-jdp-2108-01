package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.dto.OrderDto;
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
        return mapper.mapToOrderDtoList(repository.findAll());
    }

    public OrderDto getById(long id) throws EntityNotFoundException {
        return repository.findById(id).map(mapper::mapFrom).orElseThrow(() -> new EntityNotFoundException(Order.class, id));
    }

    @Transactional
    public OrderDto create(final OrderDto orderDto) {
        return saveAndMapToDto(orderDto);
    }

    @Transactional
    public void delete(final long id) throws EntityNotFoundException {
        repository.deleteById(id).orElseThrow(() -> new EntityNotFoundException(Order.class, id));
    }

    @Transactional
    public OrderDto update(final OrderDto orderDto) throws EntityNotFoundException {
        OrderDto order = repository.findById(orderDto.getId()).map(mapper::mapFrom).orElseThrow(() -> new EntityNotFoundException(Order.class, orderDto.getId()));
        return saveAndMapToDto(order);
    }

    private OrderDto saveAndMapToDto(final OrderDto orderDto) {
        Order order = repository.save(mapper.mapTo(orderDto));
        return mapper.mapFrom(order);
    }
}