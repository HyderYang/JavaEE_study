package dao;

import domain.User;

import java.util.List;

/**
 * @author: 杨欢
 * @created: 2019-05-01 22:43
 * @description:
 */
public interface UserDao {
	public List<User> findAll();

	public User getUserByUsername(String username, String password);

	public void addUser(User user);

	public void delUser(String id);
	
	public User findUser(int id);

	public void updateUser(User user);

	public int getTotalCountUser();

	public List<User> findByPage(int start, int rows);
}
