package com.example.authentication.repo;

import org.springframework.data.repository.CrudRepository;
import com.example.authentication.model.User;

public interface UserRepo extends CrudRepository<User, Integer>{
	public User findByName(String name);
	public User findByEmail(String email);
}
