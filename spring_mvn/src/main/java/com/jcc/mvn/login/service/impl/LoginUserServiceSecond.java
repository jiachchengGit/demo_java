package com.jcc.mvn.login.service.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcc.mvn.login.dao.LoginUserDAO;
import com.jcc.mvn.login.model.TLoginUsers;
import com.jcc.mvn.login.service.LoginUserService;
@Service
public class LoginUserServiceSecond {
	
	LoginUserDAO LoginUserDAO;
	public LoginUserDAO getLoginUserDAO() {
		return LoginUserDAO;
	}
	@Autowired
	public void setLoginUserDAO(LoginUserDAO loginUserDAO) {
		LoginUserDAO = loginUserDAO;
	}
	
	public String login(String userName, String password) {
		
		return "OOOOO-PPPPPP";
	}

	@Transactional(rollbackFor=Exception.class)
	public void addUser() throws Exception {
		TLoginUsers user = new TLoginUsers();
		user.setLoginUser("UserName_mvn");
		user.setPassword("password_mvn222");
		user.setDelFlag(0);
		user.setCreateDate(new Date());
		user.setUuid(UUID.randomUUID().toString());
		user.setCreateUserId(100000);
		insertUserTransaction(user);
	}
	
	private void insertUserTransaction(TLoginUsers user) throws Exception {
	    getLoginUserDAO().insertUser(user);
	    throw new Exception("just for test exception!!!");
	}
}
