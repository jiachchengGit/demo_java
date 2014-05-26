package com.jcc.mvn.login.service;

public interface LoginUserService {
	public String login(String userName,String password);

	public void addUser() throws Exception;
}
