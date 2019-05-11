package com.hyder.test;

import dao.TestDao;
import dao.impl.ItemDapImpl;
import domain.User;
import org.junit.Test;

import java.util.List;

/**
 * @author: 杨欢
 * @created: 2019-05-11 16:33
 * @description:
 */
public class DemoTest {

	@Test
	public void findAllTest() throws Exception {
		TestDao userDao = new ItemDapImpl();
		List<User> all = userDao.findAll();

		for (User user : all){
			System.out.println(user);
		}
	}
}
