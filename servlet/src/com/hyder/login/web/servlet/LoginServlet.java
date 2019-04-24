package com.hyder.login.web.servlet;

import com.hyder.login.DAO.UserDao;
import com.hyder.login.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: 杨欢
 * @created: 2019-04-24 19:50
 * @description: 登录
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);

		UserDao userDao = new UserDao();
		User login = userDao.login(user);
		if (login == null){
			req.getRequestDispatcher("/login-fail").forward(req, resp);
		}else{
			req.setAttribute("user", login);
			req.getRequestDispatcher("/login_success").forward(req,resp);
		}
	}
}
