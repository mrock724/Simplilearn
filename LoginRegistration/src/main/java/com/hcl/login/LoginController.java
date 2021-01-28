package com.hcl.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.login.CredentialsEntity;

@RestController
public class LoginController {

    @Autowired
    CredentialsEntityCrudRepository credentialsEntityCrudRepository;

    @GetMapping(path = "/register", produces = "text/html")
    String showRegister() {
        String output = "<form action='' method='POST'>";
        output += "Username: <input name='un' type='text' /><br />";
        output += "Password: <input name='pw' type='text' /><br />";
        output += "<input type='submit' />";
        output += "</form>";
        return output;
    }

    @GetMapping(path = "/login", produces = "text/html")
    String showLogin() {
        String output = "<form action='' method='POST'>";
        output += "Username: <input name='un' type='text' /><br />";
        output += "Password: <input name='pw' type='text' /><br />";
        output += "<input type='submit' />";
        output += "</form>";
        Iterable<CredentialsEntity> creds = credentialsEntityCrudRepository.findAll();
        String listCreds = "<h2>Currently saved credentials: </h2>";
        for (CredentialsEntity c: creds) {
            listCreds = listCreds + "<p>" + c.getUn() + " " + c.getPw() + "</p>";
        }
        return output + listCreds;
    }

    @PostMapping(path = "/register")
    String createCreds(@ModelAttribute CredentialsEntity creds) {
        String output = "";
    	if (creds == null || creds.getUn() == null || creds.getPw() == null) {
            output = "Error: username and/or password cannot be blank";
        } else {
        	credentialsEntityCrudRepository.save(creds);
            output = "Your credentials have been registered";
        }
        return output;
    }
    
    @PostMapping(path = "/login")
    String useCreds(@ModelAttribute CredentialsEntity creds) {
    	String output = "";
    	Iterable<CredentialsEntity> savedCreds = credentialsEntityCrudRepository.findAll();
        boolean isValid = false;
        for (CredentialsEntity c: savedCreds) {
        	if(creds.getUn().equals(c.getUn()) && creds.getPw().equals(c.getPw())) {
            	isValid = true;
            }
            /*
        	if(creds.getUn().equals(c.getUn())) {
            	//isValid = true;
        		output += "<p>" + c.getId() + " is a un match </p>";
            }
        	if(creds.getPw().equals(c.getPw())) {
            	//isValid = true;
        		output += "<p>" + c.getId() + " is a pw match </p>";
            }
            */
        }
    	if(isValid) {
    		output = "Congratulations! You are now logged in";
    	} else {
    		output = "Error: invalid login credentials";
    	}
    	
        return output;
    }

}
