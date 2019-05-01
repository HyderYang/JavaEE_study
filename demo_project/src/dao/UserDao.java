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

}
