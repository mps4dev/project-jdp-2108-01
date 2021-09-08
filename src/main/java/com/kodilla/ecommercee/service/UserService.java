package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserKey;
import com.kodilla.ecommercee.dto.UserDto;
import com.kodilla.ecommercee.dto.UserKeyDto;
import com.kodilla.ecommercee.exception.CreatingObjectWithIdException;
import com.kodilla.ecommercee.exception.EntityNotFoundException;
import com.kodilla.ecommercee.mapper.UserKeyMapper;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

@AllArgsConstructor
@Service
public class UserService {

    private final UserMapper userMapper;
    private final UserKeyMapper userKeyMapper;
    private final UserRepository repository;

    @Transactional
    public UserDto create(final UserDto userDto) throws CreatingObjectWithIdException {
        if(userDto.getId() != 0) throw new CreatingObjectWithIdException(User.class, userDto.getId());
        return saveAndMapToDto(userDto);
    }

    private UserDto saveAndMapToDto(final UserDto userDto) {
        User user = repository.save(userMapper.toEntity(userDto));
        return userMapper.toDto(user);
    }

    @Transactional
    public void block(final long id) throws EntityNotFoundException {
        User user = repository.findById(id).orElseThrow(() -> new EntityNotFoundException(User.class, id));
        repository.save(new User(user.getId(),user.getUsername(), false, user.getUserKey(), user.getCarts(), user.getOrders()));
    }

    @Transactional
    public UserKeyDto generateKey(final long id) throws EntityNotFoundException {
        User user = repository.findById(id).orElseThrow(() -> new EntityNotFoundException(User.class, id));
        Random random = new Random();
        UserKey key =  new UserKey(random.nextLong(), Instant.now().plus(Duration.ofHours(1)));
        repository.save(new User(user.getId(),user.getUsername(), user.isStatus(), key, user.getCarts(), user.getOrders()));
        return userKeyMapper.toDto(key);
    }
}
