package com.bigman.blog.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
		String url = request.getRequestURL().toString();
		String imgName = url.substring(url.indexOf("/img/")+5);
		File img = new File("/home/liuzhifeng/tupian/"+imgName);
		byte []data = new byte[1024*10];
		BufferedInputStream bis = new BufferedInputStream (new FileInputStream(img));
		int n = -1;
		while((n=bis.read(data))!=-1) {
			bos.write(data, 0, n);
		}
		bis.close();
		bos.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
