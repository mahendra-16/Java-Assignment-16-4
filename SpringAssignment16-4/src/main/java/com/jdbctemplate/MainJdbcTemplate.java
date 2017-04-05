package com.jdbctemplate;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainJdbcTemplate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext cent = new ClassPathXmlApplicationContext("spring.xml");
		
		UserDAO dao = (UserDAO) cent.getBean("userdao");
		List<User> list = dao.getAllUser();
		
		for(User user1 : list)
			System.out.println(user1);
		
		
	}

}
