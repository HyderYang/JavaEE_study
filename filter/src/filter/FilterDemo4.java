package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author: 杨欢
 * @created: 2019-05-08 23:33
 * @description: 拦截方式
 */
//@WebFilter(value = "/*", dispatcherTypes = DispatcherType.FORWARD) // 转发拦截
//@WebFilter(value = "/*", dispatcherTypes = DispatcherType.REQUEST) // 请求拦截 默认
@WebFilter(value = "/*", dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD}) // 多种方式拦截
public class FilterDemo4 implements Filter {
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
