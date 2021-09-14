package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.exception.CreatingObjectWithIdException;
import com.kodilla.ecommercee.exception.EntityNotFoundException;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CartService {

    private final CartMapper mapper;
    private final CartRepository repository;
    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;

    @Transactional
    public CartDto create(final CartDto cartDto) throws CreatingObjectWithIdException {
        if (cartDto.getId() != 0)
            throw new CreatingObjectWithIdException(Cart.class, cartDto.getId());

        return saveAndMapToDto(cartDto);
    }

    public CartDto getById(long id) throws EntityNotFoundException {
        return repository.findById(id).map(mapper::toDto).orElseThrow(() -> new EntityNotFoundException(Cart.class, id));
    }

    @Transactional
    public CartDto update(final CartDto cartDto) throws EntityNotFoundException {
        repository.findById(cartDto.getId()).orElseThrow(() -> new EntityNotFoundException(Cart.class, cartDto.getId()));
        return saveAndMapToDto(cartDto);
    }

    @Transactional
    public OrderDto order(CartDto cartDto){
        Cart cart = repository.save(mapper.toEntity(cartDto));
        Order order = new Order(0, cart.getUser(), cart);
        return orderMapper.toDto(orderRepository.save(order));
    }

    @Transactional
    public void delete(final long id) throws EntityNotFoundException {
        repository.findById(id).orElseThrow(() -> new EntityNotFoundException(Cart.class, id));
        repository.deleteById(id);
    }

    private CartDto saveAndMapToDto(final CartDto cartDto) {
        Cart cart = repository.save(mapper.toEntity(cartDto));
        return mapper.toDto(cart);
    }
}