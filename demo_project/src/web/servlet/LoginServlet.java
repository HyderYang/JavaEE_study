package web.servlet;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String captcha = request.getParameter("verifycode");

		HttpSession session = request.getSession();
		String checkcode_server = (String)session.getAttribute("CHECKCODE_SERVER");
		session.removeAttribute("CHECKCODE_SERVER");

		 if (!checkcode_server.equalsIgnoreCase(captcha)){
		 	request.setAttribute("login_msg", "验证码错误");
		 	request.getRequestDispatcher("/login.jsp").forward(request, response);
		 	return;
		 }

		Map<String, String[]> map = request.getParameterMap();

		User user = new User();

		try {
			BeanUtils.populate(user, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		UserService userService = new UserServiceImpl();
		User login = userService.login(user);
		if (login != null){
			session.setAttribute("user", login);
			response.sendRedirect("/project/index.jsp");

		}else{
			request.setAttribute("login_msg", "用户名/密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
}
