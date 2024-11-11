package com.design.splitwise.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateGroupRequestDto {
    private long userId;
    private String groupName;
    private String description;
}
