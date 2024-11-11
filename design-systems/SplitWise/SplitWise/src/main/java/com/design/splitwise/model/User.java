package com.design.splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class User extends BaseModel{
    private String name;
    private String phoneNumber;
    private String hashedPassword;
    private String email;

    @Enumerated(EnumType.ORDINAL)
    private UserStatus userStatus;

    @ManyToMany(mappedBy = "members")
    private List<Group> groups;


}
