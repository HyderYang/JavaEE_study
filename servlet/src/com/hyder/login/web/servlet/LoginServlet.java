package com.hyder.login.web.servlet;

import com.hyder.login.DAO.UserDao;
import com.hyder.login.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

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
		// 普通使用
//		String username = req.getParameter("username");
//		String password = req.getParameter("password");
//
//		User user = new User();
//		user.setUsername(username);
//		user.setPassword(password);

		// javabean
		/*
		* BeanUtils 工具类 简化数据封装
		*   1. JavaBean 标准的java类
		*       要求:
		*           1. 类必须被public修饰
		*           2. 必须提供空参的构造器
		*           3. 成员变量必须使用 private 修饰
		*           4. 提供 公共的 getter setter 方法
		*   2. 方法:
		*       setProperty()
		*       getProperty()
		*       populate()
		*
		* */
		Map<String, String[]> map = req.getParameterMap();
		User user = new User();
		try {
			BeanUtils.populate(user, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

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
