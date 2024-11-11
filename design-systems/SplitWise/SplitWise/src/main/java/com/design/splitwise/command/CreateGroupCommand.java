package com.design.splitwise.command;

import com.design.splitwise.controller.GroupController;
import com.design.splitwise.dto.CreateGroupRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CreateGroupCommand implements Command{

    private GroupController groupController;
    public CreateGroupCommand createGroupCommand;

    @Autowired
    public CreateGroupCommand(GroupController groupController) {
        this.groupController = groupController;
    }
    @Override
    public boolean match(String input) {
        List<String> inputWords = Arrays.stream(input.split(" ")).toList();
        if(inputWords.size()==4 && inputWords.get(0).equalsIgnoreCase(CommandKeyWords.ADD_GROUP)) {
            return true;
        }
        return false;
    }

    @Override
    public void execute(String input) {
        List<String> inputWords = Arrays.stream(input.split(" ")).toList();

        CreateGroupRequestDto createGroupRequestDto = new CreateGroupRequestDto();
        createGroupRequestDto.setUserId(Long.parseLong(inputWords.get(1)));
        createGroupRequestDto.setGroupName(inputWords.get(2));
        createGroupRequestDto.setDescription(inputWords.get(3));
        groupController.createGroup(createGroupRequestDto);
    }
}
