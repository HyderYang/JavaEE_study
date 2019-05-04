package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import service.UserService;

import java.util.List;

/**
 * @author: 杨欢
 * @created: 2019-05-01 22:38
 * @description: 用户列表实现
 */
public class UserServiceImpl implements UserService {
	private UserDao dao = new UserDaoImpl();

	@Override
	public List<User> findAll() {
		return dao.findAll();
	}
}