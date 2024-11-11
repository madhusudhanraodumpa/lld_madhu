package com.design.splitwise.command;

import com.design.splitwise.controller.UserController;
import com.design.splitwise.dto.CreateUserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
@Component
public class CreateUserCommand implements Command{

    private UserController userController;

    @Autowired
    public CreateUserCommand(UserController userController) {
        this.userController = userController;
    }

    @Override
    public boolean match(String input) {
        List<String> inputWords= Arrays.stream(input.split(" ")).toList();
        if(inputWords.size()==4 && inputWords.get(0).equalsIgnoreCase(CommandKeyWords.REGISTER_USER)) {
            return  true;
        }
        return false;

    }

    @Override
    public void execute(String input) {
        List<String> inputWords= Arrays.stream(input.split(" ")).toList();
        String name = inputWords.get(1);
        String phoneNumber = inputWords.get(2);
        String hashPassword = inputWords.get(3);
        CreateUserRequestDto createUserRequestDto = new CreateUserRequestDto();
        createUserRequestDto.setName(name);
        createUserRequestDto.setPhoneNumber(phoneNumber);
        createUserRequestDto.setHashPassowrd(hashPassword);
        userController.createUser(createUserRequestDto);

    }
}
