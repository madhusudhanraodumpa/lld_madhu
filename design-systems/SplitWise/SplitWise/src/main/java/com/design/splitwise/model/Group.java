package com.design.splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity(name = "splitgroup")
public class Group extends BaseModel{
    private String groupName;
    private String description;

    @ManyToMany
    private List<User> members;

    @ManyToOne
    private User createdBy;

}
