package com.hyder.download;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author: 杨欢
 * @created: 2019-04-25 21:39
 * @description: 下载
 */
@WebServlet("/download")
public class Download extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取请求参数 文件名称
		String filename = req.getParameter("filename");

		// 使用字节输入流加载文件进内存
		// 找到文件服务器路径
		ServletContext servletContext = this.getServletContext();
		// 用字节流关联
		String realPath = servletContext.getRealPath("/" + filename);

		// 设置response 响应头
		// 获取文件mime类型
		String mimeType = servletContext.getMimeType(filename);
		// 响应头类型
		resp.setHeader("content-type", mimeType);
		// 响应头打开方式
		resp.setHeader("content-disposition", "attachment;filename=" + filename);

		// 将输入流的数据写出达到输出流
		ServletOutputStream outputStream = resp.getOutputStream();
		FileInputStream stream = new FileInputStream(realPath);
		byte[] bytes = new byte[1024 * 8];
		int len = 0;
		while ((len = stream.read(bytes)) != -1){
			outputStream.write(bytes, 0, len);
		}

		stream.close();
		outputStream.close();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
