package service;

import domain.User;

import java.util.List;

/**
 * @author: 杨欢
 * @created: 2019-05-01 22:36
 * @description: 用户列表接口
 */
public interface UserService {
	public List<User> findAll();
	public User login(User user);
	public void addUser(User user);
	public void deleteUser(String id);
	public User findUser(int id);
	public void updateUser(User user);
}
