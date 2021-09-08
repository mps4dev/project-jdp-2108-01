package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.repository.ProductRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartMapper extends EntityMapper<Cart, CartDto> {

    UserRepository userRepository;
    ProductRepository productRepository;

    @Override
    public Cart toEntity(CartDto cartDto) {
        return new Cart(
                cartDto.getId(),
                cartDto.getProductsIds().stream()
                        .map(productRepository::findById)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.toList()),
                userRepository.findById(cartDto.getUserId()).orElse(null)
        );
    }

    @Override
    public CartDto toDto(Cart cart) {
        return new CartDto(
                cart.getId(),
                cart.getProducts().stream()
                        .map(Product::getId)
                        .collect(Collectors.toList()),
                cart.getUser().getId()
        );
    }
}