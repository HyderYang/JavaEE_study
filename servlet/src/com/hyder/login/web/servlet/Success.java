package com.hyder.login.web.servlet;

import com.hyder.login.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: 杨欢
 * @created: 2019-04-24 20:12
 * @description:
 */
@WebServlet("/login_success")
public class Success extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getAttribute("user");

		if(user != null){
			resp.setContentType("text/html;charset=utf-8");
			resp.getWriter().write("登录成功" + user.getUsername());
		}
	}
}
