package com.design.splitwise.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserResponseDto {
    private String status;
    private String message;
    private long userId;

}
