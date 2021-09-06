package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OrderMapper extends EntityMapper<Order, OrderDto> {

    UserRepository userRepository;
    CartRepository cartRepository;

    @Override
    public Order toEntity(OrderDto orderDto) {
        return new Order(
                orderDto.getId(),
                userRepository.findById(orderDto.getUserId()).orElse(null),
                cartRepository.findById(orderDto.getCartId()).orElse(null)
        );
    }

    @Override
    public OrderDto toDto(Order order) {
        return new OrderDto(
                order.getId(),
                order.getUser().getId(),
                order.getCart().getId()
        );
    }
}
