package com.hyder.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/CookieDemo")
public class CookieDemo extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");

		Cookie[] cookies = request.getCookies();
		boolean flag = false;
		if(cookies != null && cookies.length > 0){
			for (Cookie cookie : cookies){
				String name = cookie.getName();

				Date date = new Date();
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String format = simpleDateFormat.format(date);
				format = URLEncoder.encode(format, "utf-8");
				cookie.setValue(format);
				cookie.setMaxAge(60*60*24*30);
				response.addCookie(cookie);

				if ("lastTime".equals(name)){
					flag = true;
					String value = cookie.getValue();
					value = URLDecoder.decode(value, "utf-8");
					response.getWriter().write("欢迎回来," + value);
					break;
				}
			}
		}

		if (cookies == null || cookies.length == 0 || flag == false){
			Date date = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String format = simpleDateFormat.format(date);

			format = URLEncoder.encode(format, "utf-8");
			Cookie cookie = new Cookie("lastTime", format);
			cookie.setMaxAge(60*60*24*30);
			response.addCookie(cookie);

			response.getWriter().write("欢迎首次访问");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
}
