package com.design.splitwise.controller;

import com.design.splitwise.dto.CreateUserRequestDto;
import com.design.splitwise.dto.CreateUserResponseDto;
import com.design.splitwise.exception.UserException;
import com.design.splitwise.model.User;
import com.design.splitwise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public CreateUserResponseDto createUser(CreateUserRequestDto createUserRequestDto) {
        CreateUserResponseDto createUserResponseDto = new CreateUserResponseDto();
        try {
            User user = userService.createUser(createUserRequestDto.getName(), createUserRequestDto.getPhoneNumber(), createUserRequestDto.getHashPassowrd());
            createUserResponseDto.setStatus("SUCCESS");
            createUserResponseDto.setMessage("User created successfully");
            createUserResponseDto.setUserId(user.getId());

        } catch(UserException e) {
            createUserResponseDto.setMessage(e.getMessage());
            createUserResponseDto.setStatus("FAILED");
        }
        return createUserResponseDto;
    }
}
