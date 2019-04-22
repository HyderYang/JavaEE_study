package com.hyder.login.test;

import com.hyder.login.DAO.UserDao;
import com.hyder.login.User;
import org.junit.Test;

/**
 * @author: 杨欢
 * @created: 2019-04-23 01:36
 * @description: 单元测试
 */
public class UserDaoTest {

	@Test
	public void testLogin (){
		User user = new User();
		user.setUsername("ha");
		user.setPassword("123");

		UserDao userDao = new UserDao();
		User login = userDao.login(user);
		System.out.println(login);

	}
}
