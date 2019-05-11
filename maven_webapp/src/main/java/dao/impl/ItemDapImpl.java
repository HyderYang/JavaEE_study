package dao.impl;

import dao.TestDao;
import domain.User;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: 杨欢
 * @created: 2019-05-11 16:11
 * @description:
 */
public class ItemDapImpl implements TestDao {

	@Override
	public List<User> findAll() throws Exception {
		Connection connection = null;
		CallableStatement call = null;
		ResultSet resultSet = null;
		List<User>list = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql:///java", "root", "root");

			String sql = "select * from user";
			call = connection.prepareCall(sql);
			resultSet = call.executeQuery();

			while (resultSet.next()){
				User user = new User();
				user.setId(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setGender(resultSet.getString(3));
				user.setAge(resultSet.getInt(4));
				user.setAddress(resultSet.getString(5));
				user.setQq(resultSet.getString(6));
				user.setEmail(resultSet.getString(7));

				list.add(user);
			}
		} finally {
			resultSet.close();
			call.close();
			connection.close();
		}

		return list;
	}
}
