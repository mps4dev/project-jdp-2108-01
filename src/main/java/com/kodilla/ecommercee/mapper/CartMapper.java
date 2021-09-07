package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CartMapper extends EntityMapper<Cart, CartDto> {

    UserRepository userRepository;
    @Override
    public Cart toEntity(CartDto cartDto) {
        return new Cart(
                cartDto.getId(),
                cartDto.getProductsIds(),
                userRepository.findById(cartDto.getUserId()).orElse(null)
        );
    }

    @Override
    public CartDto toDto(Cart cart) {
        return new CartDto(
                cart.getId(),
                cart.getProducts(),
                cart.getUser().getId()
        );
    }
}