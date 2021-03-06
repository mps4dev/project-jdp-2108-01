package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.UserKey;
import com.kodilla.ecommercee.dto.UserKeyDto;
import org.springframework.stereotype.Service;

@Service
public class UserKeyMapper extends EntityMapper<UserKey, UserKeyDto> {

    @Override
    public UserKeyDto toDto(final UserKey userKey) {
        return new UserKeyDto(
                userKey.getValue(),
                userKey.getExpirationTime()
        );
    }

    @Override
    public UserKey toEntity(UserKeyDto userKeyDto) {
        return new UserKey(
                userKeyDto.getValue(),
                userKeyDto.getExpirationTime()
        );
    }

}
