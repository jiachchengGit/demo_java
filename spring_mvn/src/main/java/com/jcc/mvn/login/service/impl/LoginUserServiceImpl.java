package com.jcc.mvn.login.service.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcc.mvn.login.dao.LoginUserDAO;
import com.jcc.mvn.login.model.TLoginUsers;
import com.jcc.mvn.login.service.LoginUserService;

@Service(value="loginUserServiceImpl")
public class LoginUserServiceImpl implements LoginUserService {
	
	LoginUserDAO LoginUserDAO;
	public LoginUserDAO getLoginUserDAO() {
		return LoginUserDAO;
	}
	@Autowired
	public void setLoginUserDAO(LoginUserDAO loginUserDAO) {
		LoginUserDAO = loginUserDAO;
	}
	
	@Override
	public String login(String userName, String password) {
		return "Login successful";
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void addUser() throws Exception {
		TLoginUsers user = new TLoginUsers();
		user.setLoginUser("UserName_mvn");
		user.setPassword("password_mvn");
		user.setDelFlag(0);
		user.setCreateDate(new Date());
		user.setUuid(UUID.randomUUID().toString());
		user.setCreateUserId(100000);
		insertUserTransaction(user);
//		throw new Exception("just for test exception!!!");
	}
	private void insertUserTransaction(TLoginUsers user) {
	    getLoginUserDAO().insertUser(user);
	}
}
