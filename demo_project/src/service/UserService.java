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
}
