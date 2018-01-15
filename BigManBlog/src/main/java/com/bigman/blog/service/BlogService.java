package com.bigman.blog.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface BlogService {

	Integer sendMicroBlog(HttpServletRequest request,HttpSession session);
	
	
}
