package com.design.bookmyshow.controller;

import com.design.bookmyshow.dto.SignUpUserRequestDto;
import com.design.bookmyshow.dto.SignUpUserResponseDto;
import com.design.bookmyshow.model.User;
import com.design.bookmyshow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public SignUpUserResponseDto signUpUser(SignUpUserRequestDto request) {
        User user = userService.signUpUser(
                request.getEmail(), request.getPassword()
        );

        SignUpUserResponseDto response = new SignUpUserResponseDto();
        response.setUserId(user.getId());

        return response;
    }
}
