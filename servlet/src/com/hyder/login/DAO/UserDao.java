package com.hyder.login.DAO;

import com.hyder.login.User;
import com.hyder.login.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author: 杨欢
 * @created: 2019-04-23 01:17
 * @description: 操作数据库中User表的类
 */
public class UserDao {
	private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

	public User login(User loginUser) {
		String sql = "select * from user where username=? and password=?";
		User user = template.queryForObject(
				sql,
				new BeanPropertyRowMapper<User>(User.class),
				loginUser.getUsername(),
				loginUser.getPassword()
		);

		return user;
	}
}
