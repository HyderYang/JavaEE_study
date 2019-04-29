package com.hyder.el;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/JSTLServlet")
public class JSTLServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		1. 概念：JavaServer Pages Tag Library  JSP标准标签库
			是由Apache组织提供的开源的免费的jsp标签		<标签>

		2. 作用：用于简化和替换jsp页面上的java代码

		3. 使用步骤：
			1. 导入jstl相关jar包
			2. 引入标签库：taglib指令：  <%@ taglib %>
			3. 使用标签

		4. 常用的JSTL标签
			1. if:相当于java代码的if语句
				1. 属性：
		            * test 必须属性，接受boolean表达式
		                * 如果表达式为true，则显示if标签体内容，如果为false，则不显示标签体内容
		                * 一般情况下，test属性值会结合el表达式一起使用
	             2. 注意：
		             * c:if标签没有else情况，想要else情况，则可以在定义一个c:if标签
			2. choose:相当于java代码的switch语句
				1. 使用choose标签声明         			相当于switch声明
	            2. 使用when标签做判断         			相当于case
	            3. 使用otherwise标签做其他情况的声明    	相当于default

			3. foreach:相当于java代码的for语句
		 */
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
}
