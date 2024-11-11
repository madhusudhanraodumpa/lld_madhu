package com.design.splitwise.service;

import com.design.splitwise.exception.GroupException;
import com.design.splitwise.model.Group;
import com.design.splitwise.model.User;
import com.design.splitwise.repository.GroupRepository;
import com.design.splitwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GroupService {
    private UserRepository userRepository;
    private GroupRepository groupRepository;

    @Autowired
    public GroupService(UserRepository userRepository,GroupRepository groupRepository) {
        this.userRepository = userRepository;
        this.groupRepository= groupRepository;
    }


    public Group createGroup(Long userId, String groupName, String description) throws GroupException {
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()) {
            Group group = new Group();
            group.setCreatedBy(user.get());
            group.setGroupName(groupName);
            group.setDescription(description);
            return groupRepository.save(group);

        }else {
            throw new GroupException("Created user not exits. register new user and create group.");
        }


    }
}
