package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.dto.UserDto;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserMapper extends EntityMapper<User, UserDto> {

    private final CartRepository cartRepository;
    private final OrderRepository orderRepository;
    private final UserKeyMapper userKeyMapper;

    @Override
    public User toEntity(final UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getUsername(),
                userDto.isBlocked(),
                userKeyMapper.toEntity(userDto.getUserKeyDto()),
                userDto.getCartsId().stream()
                        .map(cartRepository::findById)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.toList()),
                userDto.getOrdersId().stream()
                        .map(orderRepository::findById)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.toList())

        );
    }

    @Override
    public UserDto toDto(final User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.isBlocked(),
                userKeyMapper.toDto(user.getUserKey()),
                user.getCarts().stream()
                        .map(Cart::getId)
                        .collect(Collectors.toList()),
                user.getOrders().stream()
                        .map(Order::getId)
                        .collect(Collectors.toList())
        );
    }
}
