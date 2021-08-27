package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.dto.OrderDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderMapper {

    public Order mapToOrder(final OrderDto orderDto){
        return new Order(orderDto.getId(), orderDto.getUser(), orderDto.getCart());
    }

    public OrderDto mapToDto(final Order order){
        return new OrderDto(order.getId(), order.getUser(), order.getCart());
    }

    public List<OrderDto> mapToOrderDtoList(final List<Order> groups){
        return groups.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }
}
