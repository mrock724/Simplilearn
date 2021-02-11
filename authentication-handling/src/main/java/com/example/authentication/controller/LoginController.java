package com.example.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.authentication.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@GetMapping("/")
    public String showGreeting(ModelMap map) {
        return "greeting";
    }
    
	@GetMapping("/login")
    public String showLogin(ModelMap map) {
        return "login";
    }
    @PostMapping("/login")
    public String submitLogin(@RequestParam String username, @RequestParam String password){
        loginService.AuthenticateUser(loginService.GetUserByName(username), password);
        return "Success";
    }
}
