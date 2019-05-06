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

	@Override
	public void addUser(User user) {
		String sql = "insert into user values(null, ?, ?, ?, ?, ?, ?, null, null)";
		template.update(sql, user.getName(), user.getGender(), user.getAge(),
				user.getAddress(), user.getQq(), user.getEmail());

	}

	@Override
	public void delUser(String id) {
		int uid = Integer.parseInt(id);
		String sql = "delete from user where id = ?";
		template.update(sql, uid);
	}

	@Override
	public User findUser(int id) {
		String sql = "select * from user where id = ?";
		return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
	}

	@Override
	public void updateUser(User user) {
		String sql = "update user set name = ?, gender = ?, age = ?, address = ?, qq = ?, email = ? where id = ?";
		template.update(sql, user.getName(), user.getGender(), user.getAge(),
				user.getAddress(), user.getQq(), user.getEmail(), user.getId());
	}

	@Override
	public int getTotalCountUser() {
		String sql = "select count(*) from user";
		return template.queryForObject(sql, Integer.class);
	}

	@Override
	public List<User> findByPage(int start, int rows) {
		String sql = "select * from user limit ?, ?";
		return template.query(sql, new BeanPropertyRowMapper<User>(User.class), start, rows);
	}
}
