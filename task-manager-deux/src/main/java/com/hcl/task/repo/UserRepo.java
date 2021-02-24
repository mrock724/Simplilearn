package com.hcl.task.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.task.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    //User findByEmail(String email);
    User findByUserName(String userName);
}