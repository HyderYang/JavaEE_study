package dao;

import domain.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: 杨欢
 * @created: 2019-05-11 16:09
 * @description:
 */
public interface TestDao {
	public List<User> findAll() throws SQLException, Exception;
}
