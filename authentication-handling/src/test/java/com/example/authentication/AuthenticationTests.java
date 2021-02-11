package com.example.authentication;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.authentication.model.User;
import com.example.authentication.repo.UserRepo;
import com.example.authentication.service.LoginService;

@DataJpaTest
public class AuthenticationTests {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private UserRepo userRepo;
	
	//@Autowired
    private LoginService loginService = new LoginService();
	
	@Test
	public void whenFindByName_thenReturnUser() {
		//given
		User dummyUser = new User();
		dummyUser.setName("Dummy User");
		dummyUser.setEmail("test@test.test");
		dummyUser.setPassword("password");
		entityManager.persist(dummyUser);
		entityManager.flush();
		//when
		User found = userRepo.findByName(dummyUser.getName());
		//then
		assertEquals(found.getName(), dummyUser.getName());
	}
	
	@Test
	public void whenFindByEmail_thenReturnUser() {
		//given
		User dummyUser = new User();
		dummyUser.setName("Dummy User");
		dummyUser.setEmail("test@test.test");
		dummyUser.setPassword("password");
		entityManager.persist(dummyUser);
		entityManager.flush();
		//when
		User found = userRepo.findByEmail(dummyUser.getEmail());
		//then
		assertEquals(found.getEmail(), dummyUser.getEmail());
	}
	
	@Test
	public void whenAddNullUser_thenReturnFalse() {
		User dummyUser = null;
		boolean added = loginService.AbleToAddUser(dummyUser);
		assertEquals(added, false);
	}
	
	@Test
	public void whenAddValidUser_thenReturnTrue() {
		User dummyUser = new User();
		dummyUser.setName("Dummy User");
		dummyUser.setEmail("test@test.test");
		dummyUser.setPassword("password");
		//boolean added = loginService.AbleToAddUser(dummyUser);
		boolean added = false;
		userRepo.save(dummyUser);
		Iterable<User> users = userRepo.findAll();
		for(User user : users) {
			if(user != null) {
				added = true;
				break;
			}
		}
        assertEquals(added, true);
	}
	
	@Test
	public void whenAuthenticateUser_thenReturnTrue() {
        User dummyUser = new User();
        dummyUser.setName("Dummy User");
        dummyUser.setEmail("test@test.test");
        dummyUser.setPassword("password");
        boolean authenticated = loginService.AuthenticateUser(dummyUser, "password");
        assertEquals(authenticated, true);
    }
    
}
