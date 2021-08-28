package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.dto.OrderDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderMapper extends EntityMapper<Order, OrderDto> {

    @Override
    public OrderDto mapFrom(Order order) {
        return new OrderDto(
                order.getId(),
                order.getUser(),
                order.getCart()
        );
    }

    @Override
    public Order mapTo(OrderDto orderDto) {
        return new Order(
                orderDto.getId(),
                orderDto.getUser(),
                orderDto.getCart()
        );
    }

    public List<OrderDto> mapToOrderDtoList(final List<Order> orders) {
        return orders.stream()
                .map(this::mapFrom)
                .collect(Collectors.toList());
    }
}