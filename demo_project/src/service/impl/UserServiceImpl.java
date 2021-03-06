package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.PageBean;
import domain.User;
import service.UserService;

import java.util.List;

/**
 * @author: 杨欢
 * @created: 2019-05-01 22:38
 * @description: 用户列表实现
 */
public class UserServiceImpl implements UserService {
	private UserDao dao = new UserDaoImpl();

	@Override
	public List<User> findAll() {
		return dao.findAll();
	}

	@Override
	public User login(User user) {
		return dao.getUserByUsername(user.getUsername(), user.getPassword());
	}

	@Override
	public void addUser(User user) {
		dao.addUser(user);
	}

	@Override
	public void deleteUser(String id) {
		dao.delUser(id);
	}

	@Override
	public User findUser(int id) {
		return dao.findUser(id);
	}

	@Override
	public void updateUser(User user) {
		dao.updateUser(user);
	}

	@Override
	public PageBean<User> findUserByPage(String currentPage, String rows) {
		int _currentPage = Integer.parseInt(currentPage);
		int _rows = Integer.parseInt(rows);
		PageBean<User> pb = new PageBean<User>();
		pb.setCurrentPage(_currentPage);
		pb.setRows(_rows);

		int totalCount = dao.getTotalCountUser();
		pb.setTotalCount(totalCount);

		int start = (_currentPage - 1) * _rows;
		List<User> list = dao.findByPage(start, _rows);
		pb.setList(list);
		pb.setTotalPage(totalCount % _rows == 0 ? totalCount / _rows : totalCount / _rows + 1);
		return pb;
	}
}
