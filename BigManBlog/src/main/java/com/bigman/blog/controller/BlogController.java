package com.bigman.blog.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bigman.blog.service.BlogService;

@Controller
@RequestMapping("/blog")
public class BlogController {

	@Resource
	private BlogService service;
	
	@ResponseBody
	@RequestMapping("/sendMicroBlog.do")
	public String sendMicroBlog(HttpServletRequest request,HttpSession session)  {
		
		service.sendMicroBlog(request, session);
		
		return "";
	}
	
}
