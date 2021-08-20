package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.UserDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @PostMapping(value = "createUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(UserDto userDto){

    }
    @DeleteMapping(value = "deleteUser")
    public void deleteUser(int userId){

    }
    @PutMapping(value = "updateUser")
    public UserDto updateUser(UserDto userDto){
        return new UserDto();
    }

    @GetMapping(value = "getUser")
    public UserDto getUser(int taskId){
        return new UserDto();
    }

    @GetMapping(value = "getAllUsers")
    public List<UserDto> getAllUsers(){
        return new ArrayList<>();
    }


}
