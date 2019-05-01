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
}
