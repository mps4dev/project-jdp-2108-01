package com.kodilla.ecommercee.dto;

import com.kodilla.ecommercee.domain.UserKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserDto {

    private long id;
    private String username;
    private boolean status;
    private UserKey userKey;
    private List<Long> cartsId;
    private List<Long> ordersId;
}
