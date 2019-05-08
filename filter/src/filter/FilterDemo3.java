package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author: 杨欢
 * @created: 2019-05-08 22:50
 * @description: 资源拦截
 */
//@WebFilter("/index.jsp") //具体资源路径拦截
//@WebFilter("/user/*") //目录拦截 目录下所有资源都会被拦截
@WebFilter("/*.jsp") //后缀名拦截
public class FilterDemo3 implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

	}

	@Override
	public void destroy() {

	}
}
