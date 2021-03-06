package com.hcl.task.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.task.model.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {
    Role findByRole(String role);

}
