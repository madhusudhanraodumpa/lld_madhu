package com.design.splitwise.service;

import com.design.splitwise.repository.UserRepository;
import com.design.splitwise.exception.UserException;
import com.design.splitwise.model.User;
import com.design.splitwise.model.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String username,String phoneNumber,String hashPassword) throws UserException{

        Optional<User> userOptional = userRepository.findByPhoneNumber(phoneNumber);
        if(userOptional.isPresent()) {
            if(userOptional.get().getUserStatus().equals(UserStatus.ACTIVE)) {
                throw new UserException("User laredy exits . please try to login.");
            } else {
                User user = userOptional.get();
                user.setUserStatus(UserStatus.ACTIVE);
                user.setName(username);
                user.setPhoneNumber(phoneNumber);
                user.setHashedPassword(hashPassword);
                return userRepository.save(user);
            }
        }
        User user = new User();
        user.setHashedPassword(hashPassword);
        user.setUserStatus(UserStatus.ACTIVE);
        user.setPhoneNumber(phoneNumber);
        user.setName(username);
        user = userRepository.save(user);

        return user;
    }
}
