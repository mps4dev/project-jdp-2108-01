package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.exception.NoSuchIdException;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class OrderService {

    private final OrderMapper mapper;
    private final OrderRepository repository;

    public List<OrderDto> getAll(){
        return mapper.mapToOrderDtoList(repository.findAll());
    }

    public OrderDto getById(long id) throws NoSuchIdException{
        Optional<Order> order = repository.findById(id);

        if(order.isPresent()){
            return mapper.mapToDto(order.get());
        }else{
            throw new NoSuchIdException();
        }
    }

    @Transactional
    public OrderDto create(final OrderDto orderDto){
        return saveAndMapToDto(orderDto);
    }

    @Transactional
    public void delete(final long id) throws NoSuchIdException{
        Optional<Order> order = repository.findById(id);

        if(order.isPresent()){
            repository.deleteById(id);
        }else{
            throw new NoSuchIdException();
        }
    }

    @Transactional
    public OrderDto update(final OrderDto orderDto) throws NoSuchIdException{
        Optional<Order> order = repository.findById(orderDto.getId());

        if(order.isPresent()){
            return saveAndMapToDto(orderDto);
        }else{
            throw new NoSuchIdException();
        }
    }

    public OrderDto saveAndMapToDto(final OrderDto orderDto){
        Order order = repository.save(mapper.mapToOrder(orderDto));
        return mapper.mapToDto(order);
    }
}
