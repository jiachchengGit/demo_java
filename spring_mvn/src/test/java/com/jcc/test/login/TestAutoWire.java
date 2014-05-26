package com.jcc.test.login;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.jcc.mvn.login.web.LoginUserController;

public class TestAutoWire {

	public static void main(String[] args) {
		ApplicationContext cxt = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		LoginUserController bean = cxt.getBean(LoginUserController.class);
		bean.addUser();
		
//		LoginUserServiceSecond bean2 = cxt.getBean(LoginUserServiceSecond.class);
//		try {
//			bean2.addUser();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}
