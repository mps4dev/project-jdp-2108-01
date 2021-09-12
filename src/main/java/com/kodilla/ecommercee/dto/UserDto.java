package com.kodilla.ecommercee.dto;

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
    private boolean blocked;
    private UserKeyDto userKey;
    private List<Long> cartsId;
    private List<Long> ordersId;
}
