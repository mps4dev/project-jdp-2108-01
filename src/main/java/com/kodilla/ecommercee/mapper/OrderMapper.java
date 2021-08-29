package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.dto.OrderDto;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper extends EntityMapper<Order, OrderDto> {

    @Override
    public Order toEntity(OrderDto orderDto) {
        return new Order(
                orderDto.getId(),
                orderDto.getUser(),
                orderDto.getCart()
        );
    }

    @Override
    public OrderDto toDto(Order order) {
        return new OrderDto(
                order.getId(),
                order.getUser(),
                order.getCart()
        );
    }
}