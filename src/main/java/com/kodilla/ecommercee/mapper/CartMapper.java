package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.dto.CartDto;
import org.springframework.stereotype.Service;

@Service
public class CartMapper extends EntityMapper<Cart, CartDto> {

    @Override
    public Cart toEntity(CartDto cartDto) {
        return new Cart(
                cartDto.getId(),
                cartDto.getProducts(),
                cartDto.getUser()
        );
    }

    @Override
    public CartDto toDto(Cart cart) {
        return new CartDto(
                cart.getId(),
                cart.getProducts(),
                cart.getUser()
        );
    }
}
