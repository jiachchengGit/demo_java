package com.jcc.mvn.login.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.jcc.mvn.login.service.LoginUserService;

@Controller
public class LoginUserController {
   
	LoginUserService loginService;
	
	public LoginUserService getLoginService() {
		return loginService;
	}
    
	@Autowired
	@Qualifier(value="loginUserServiceImpl")
	public void setLoginService(LoginUserService loginService) {
		this.loginService = loginService;
	}
	
	public void login(){
		String login = loginService.login("", "");
		System.out.println("login = "+login);
	}
	
	public void addUser(){
		try {
			loginService.addUser();
			System.out.println("Add User OK !");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
