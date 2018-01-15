package com.bigman.blog.serviceImpl;

import java.io.BufferedReader;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.bigman.blog.bean.MicroBlog;
import com.bigman.blog.bean.User;
import com.bigman.blog.dao.MicroBlogDao;
import com.bigman.blog.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService {

	@Resource
	private MicroBlogDao dao;

	public Integer sendMicroBlog(HttpServletRequest request, HttpSession session) {

		StringBuilder sb = null;
		try {
			BufferedReader reader = request.getReader();
			String line = null;
			sb = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		String mesString = sb.toString();
		/**********************/
		byte[] spbs = { -62, -96 };// 替换诡异的空格
		String sp = new String(spbs);
		/************************/
		mesString = mesString.replaceAll("[\\s" + sp + "]+", " ");// 把多余的空格置换成单个空格
		/*************** 存入数据库 ***********************/
		User u = (User) session.getAttribute("user");
		MicroBlog mb = new MicroBlog(null, u.getId(), 1, null, mesString);
		Integer n = dao.addBlog(mb);
		if (n != 1)
			throw new RuntimeException("发送微博失败");
		return n;
	}

}
