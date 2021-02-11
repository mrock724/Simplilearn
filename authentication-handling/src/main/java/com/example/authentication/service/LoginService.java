package com.example.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.authentication.model.User;
import com.example.authentication.repo.UserRepo;

@Service
public class LoginService {
	
	@Autowired
	private UserRepo userRepo;
	
	public boolean AbleToAddUser(User newUser) {
		if (newUser == null) {
			return false;
		}
		//userRepo.save(newUser);
        return true;
	}
	public User GetUserByName(String name) {
		/*
		Iterable<User> users = userRepo.findAll();
		for(User user : users) {
			if(user.getName().equals(name)) {
				return user;
			}
		}
		return null;
		*/
		return userRepo.findByName(name);
	}
	public User GetUserByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	public boolean AuthenticateUser(User user, String password) {
		return (user.getPassword().equals(password));
	}
}
