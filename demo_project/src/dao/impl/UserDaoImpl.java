package dao.impl;

import dao.UserDao;
import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

/**
 * @author: 杨欢
 * @created: 2019-05-01 22:45
 * @description:
 */
public class UserDaoImpl implements UserDao {
	private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

	@Override
	public List<User> findAll() {
		String sql = "select * from user";
		List<User> query = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
		return query;
	}

	@Override
	public User getUserByUsername(String username, String password) {
		try {
			String sql = "select * from user where username = ? and password = ?";
			User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
			return user;
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}

	}
}
