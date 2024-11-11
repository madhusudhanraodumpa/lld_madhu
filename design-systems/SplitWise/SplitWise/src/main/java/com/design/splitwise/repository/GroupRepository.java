package com.design.splitwise.repository;

import com.design.splitwise.model.Group;
import com.design.splitwise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {
    @Override
    Optional<Group> findById(Long aLong);

   Optional<Group> findByGroupNameAndCreatedBy(String groupName, User createdBy);

    Group save(Group group);
}
