package com.hcl.userinfo.update;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateController {

    @Autowired
    UserEntityRepo userEntityRepo;

    @GetMapping(path = "/create", produces = "text/html")
    String showCreate() {
        String output = "<form action='' method='POST'>";
        output += "<h2>Enter the name for the new user</h2>";
        output += "Name: <input name='name' type='text' /><br />";
        output += "<input type='submit' />";
        output += "</form>";
        return output;
    }

    @PostMapping(path = "/create")
    String createUser(@ModelAttribute UserEntity user) {
        String output = "";
    	if (user == null || user.getName() == null) {
            //throw new RuntimeException("Name field cannot be left blank");
            output = "Name field cannot be left blank";
        } else {
        	userEntityRepo.save(user);
        	output = "Created new user at ID number: " + user.getId();
        }
    	return output;
    }
    
    @GetMapping(path = "/search", produces = "text/html")
    String showSearch() {
        String output = "<form action='' method='POST'>";
        output += "<h2>Enter the ID number for which to search</h2>";
        output += "ID: <input name='id' type='text' /><br />";
        output += "<input type='submit' />";
        output += "</form>";
        return output;
    }

    @PostMapping(path = "/search")
    String searchUser(@ModelAttribute UserEntity givenUser) {
        String output = "";
        if (givenUser == null || givenUser.getId() == null) {
            //throw new RuntimeException("ID field cannot be left blank");
            output = "ID field cannot be left blank";
        } else {
        	Iterable<UserEntity> savedUser = userEntityRepo.findAll();
            for (UserEntity u: savedUser) {
            	if(givenUser.getId().equals(u.getId())) {
                	output += "<p>ID: " + u.getId() + "</p>";
                	output += "<p>Name: " + u.getName() + "</p>";
                	return output;
                }
            }
        	output = "Error: invalid ID number";
        }
    	return output;
    }
    
    @GetMapping(path = "/update", produces = "text/html")
    String showUpdate() {
        String output = "<form action='' method='POST'>";
        output += "<p>Enter the ID of the user to be updated</p>";
        output += "ID: <input name='id' type='text' /><br />";
        output += "<p>Enter the new name for the user</p>";
        output += "Name: <input name='name' type='text' /><br />";
        output += "<input type='submit' />";
        output += "</form>";
        return output;
    }

    @PostMapping(path = "/update")
    String updateUser(@ModelAttribute UserEntity givenUser) {
        String output = "";
        if (givenUser == null || givenUser.getId() == null ||givenUser.getName() == null ) {
            //throw new RuntimeException("Name field cannot be left blank");
            output = "Fields cannot be left blank";
        } else {
        	Iterable<UserEntity> savedUser = userEntityRepo.findAll();
            for (UserEntity u: savedUser) {
            	if(givenUser.getId().equals(u.getId())) {
                	output += "<p>ID number: " + u.getId() + "</p>";
                	output += "<p>Old Name: " + u.getName() + "</p>";
                	output += "<p>New Name: " + givenUser.getName() + "</p>";
                	u.setName(givenUser.getName());
                	userEntityRepo.save(u);
                	return output;
                }
            }
        	output = "Error: invalid ID number";
        }
    	return output;
    }
    
    @GetMapping(path = "/home", produces = "text/html")
    String home() {
        Iterable<UserEntity> users = userEntityRepo.findAll();
        String output = "<h2>All users</h2>";
        for (UserEntity u: users) {
        	output += "<p>ID: " + u.getId() + "</p>";
        	output += "<p>Name: " + u.getName() + "</p>";
        }
        return output;
    }

}
