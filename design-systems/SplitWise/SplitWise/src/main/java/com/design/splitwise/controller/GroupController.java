package com.design.splitwise.controller;

import com.design.splitwise.dto.CreateGroupRequestDto;
import com.design.splitwise.dto.CreateGroupResponseDto;
import com.design.splitwise.exception.GroupException;
import com.design.splitwise.model.Group;
import com.design.splitwise.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GroupController {
    private GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    public CreateGroupResponseDto createGroup(CreateGroupRequestDto createGroupRequestDto) {
        CreateGroupResponseDto createGroupResponseDto = new CreateGroupResponseDto();
        try {
            Group group = groupService.createGroup(createGroupRequestDto.getUserId(), createGroupRequestDto.getGroupName(), createGroupRequestDto.getDescription());
            createGroupResponseDto.setGroupId(group.getId());
            createGroupResponseDto.setStatus("SUCCESS");
            createGroupResponseDto.setMessage("Created group successfully.");
        } catch (GroupException groupException) {
            createGroupResponseDto.setMessage(groupException.getMessage());
            createGroupResponseDto.setStatus("FAILED");
        }
        return createGroupResponseDto;

    }

}
