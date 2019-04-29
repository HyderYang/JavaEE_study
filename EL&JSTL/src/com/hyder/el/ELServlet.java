package com.hyder.el;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ELServlet")
public class ELServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		* 1. 指令
		* 作用：用于配置JSP页面，导入资源文件
		* 格式：
		*	<%@ 指令名称 属性名1=属性值1 属性名2=属性值2 ... %>
		* 分类：
		*	1. page		： 配置JSP页面的
		*		* contentType：等同于response.setContentType()
		*			1. 设置响应体的mime类型以及字符集
		*			2. 设置当前jsp页面的编码（只能是高级的IDE才能生效，如果使用低级工具，则需要设置pageEncoding属性设置当前页面的字符集）
		*		* import：导包
		*		* errorPage：当前页面发生异常后，会自动跳转到指定的错误页面
		*		* isErrorPage：标识当前也是是否是错误页面。
		*			* true：是，可以使用内置对象exception
		*			* false：否。默认值。不可以使用内置对象exception
		*	2. include	： 页面包含的。导入页面的资源文件
		*		* <%@include file="top.jsp"%>
		*	3. taglib	： 导入资源
		*		* <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		*			* prefix：前缀，自定义的
		*
		* 	2. 注释:
		*		1. html注释：
		*			<!-- -->:只能注释html代码片段
		*		2. jsp注释：推荐使用
		*			<%-- --%>：可以注释所有
		*
		*
		*	3. 内置对象
		*		* 在jsp页面中不需要创建，直接使用的对象
		*		* 一共有9个：
		*				变量名					真实类型						作用
		*			* pageContext				PageContext					当前页面共享数据，还可以获取其他八个内置对象
		*			* request					HttpServletRequest			一次请求访问的多个资源(转发)
		*			* session					HttpSession					一次会话的多个请求间
		*			* application				ServletContext				所有用户间共享数据
		*			* response					HttpServletResponse			响应对象
		*			* page						Object						当前页面(Servlet)的对象  this
		*			* out						JspWriter					输出对象，数据输出到页面上
		*			* config					ServletConfig				Servlet的配置对象
		*			* exception					Throwable					异常对象
		*
		*	1. 概念：Expression Language 表达式语言
		*	2. 作用：替换和简化jsp页面中java代码的编写
		*	3. 语法：${表达式}
		*	4. 注意：
		*		* jsp默认支持el表达式的。如果要忽略el表达式
		*			1. 设置jsp中page指令中：isELIgnored="true" 忽略当前jsp页面中所有的el表达式
		*			2. \${表达式} ：忽略当前这个el表达式
		*
		*
		*	5. 使用：
		*		1. 运算：
		*			* 运算符：
		*				1. 算数运算符： + - * /(div) %(mod)
		*				2. 比较运算符： > < >= <= == !=
		*				3. 逻辑运算符： &&(and) ||(or) !(not)
		*				4. 空运算符： empty
		*					* 功能：用于判断字符串、集合、数组对象是否为null或者长度是否为0
		*					* ${empty list}:判断字符串、集合、数组对象是否为null或者长度为0
		*					* ${not empty str}:表示判断字符串、集合、数组对象是否不为null 并且 长度>0
		*		2. 获取值
		*			1. el表达式只能从域对象中获取值
		*			2. 语法：
		*				1. ${域名称.键名}：从指定域中获取指定键的值
		*					* 域名称：
		*						1. pageScope		--> pageContext
		*						2. requestScope 	--> request
		*						3. sessionScope 	--> session
		*						4. applicationScope --> application（ServletContext）
		*					* 举例：在request域中存储了name=张三
		*					* 获取：${requestScope.name}
		*
		*				2. ${键名}：表示依次从最小的域中查找是否有该键对应的值，直到找到为止。
		*
		*
		*
		*				3. 获取对象、List集合、Map集合的值
		*					1. 对象：${域名称.键名.属性名}
		*						* 本质上会去调用对象的getter方法
		*
		*					2. List集合：${域名称.键名[索引]}
		*
		*					3. Map集合：
		*						* ${域名称.键名.key名称}
		*						* ${域名称.键名["key名称"]}
		*
		*
		*		3. 隐式对象：
		*			* el表达式中有11个隐式对象
		*			* pageContext：
		*				* 获取jsp其他八个内置对象
		*					* ${pageContext.request.contextPath}：动态获取虚拟目录
		* */
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
}
