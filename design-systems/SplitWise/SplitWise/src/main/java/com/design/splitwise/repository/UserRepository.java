package com.design.splitwise.repository;

import com.design.splitwise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User save(User user);

    @Override
    Optional<User> findById(Long aLong);

    Optional<User> findByPhoneNumber(String phoneNumber);

    List<User> findAllByGroupId(long groupId);
}
