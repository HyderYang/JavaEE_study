package filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author: 杨欢
 * @created: 2019-05-08 22:42
 * @description: 生命周期
 */
public class FilterDemo2 implements Filter {

	// 服务器启动后 创建 filter 对象
	// 执行一次
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	// 执行多次
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		// 放行
		filterChain.doFilter(servletRequest, servletResponse);
		//执行后续文件
		//执行完毕回来

		//执行下面代码


	}

	// 服务器关闭后 filter对象销毁 如果服务器正常关闭 执行此方法
	// 执行一次
	@Override
	public void destroy() {

	}
}
