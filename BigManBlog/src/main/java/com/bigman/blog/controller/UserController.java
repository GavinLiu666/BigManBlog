package com.bigman.blog.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bigman.blog.bean.User;
import com.bigman.blog.bean.User_info;
import com.bigman.blog.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("index.do")
	public String index() {//显示登录页
		return "index";
	}
	
	@Resource
	private UserService userService ;
	
	@ResponseBody//申请登录
	@RequestMapping("/login.do")
	public String login(String username,String password,HttpSession session) {
		String message = userService.login(username, password,session);
		return message;
	}
	
	
	
	@RequestMapping("/home.do")//显示用户home页
	public String showHomePage(HttpSession session) {
		userService.showHomePage(session);
		return "homepage";
	}
	
	@ResponseBody
	@RequestMapping("/uploadPortrait.do")//更换头像
	public String upLoadPortrait(HttpServletRequest request,HttpServletResponse response) {
		String message = userService.upload(request,response);
		return message;
	}
	
	
		
	@ResponseBody
	@RequestMapping("/search.do")
	public String searchUser(String name,HttpSession session) {
		User_info friendInfo = userService.findUserInfoByName(name);
		if(friendInfo==null) {return "error";}
		session.setAttribute("search_friend", friendInfo);
		return "success";
	}
	
	@RequestMapping("/friend.do")
	public String showFriend(HttpSession session) {
		User_info friendInfo = (User_info) session.getAttribute("search_friend");
		User user = (User) session.getAttribute("user");
		userService.isAttend(user.getId(), friendInfo.getId(), session);
		return "friend";
	}
	
	/**
	 * 如果已经是对方粉丝，则取消关注，否则关注该用户
	 * @param session
	 * @return
	 */
	@RequestMapping("/attend.do")
	public String attendFriend(HttpSession session) {
		User_info friendInfo = (User_info) session.getAttribute("search_friend");
		Boolean isAttend = (Boolean) session.getAttribute("isAttend");
		if(isAttend) {
			userService.rmAttend(friendInfo.getId(), session);
		}
		userService.addAttend(friendInfo.getId(), session);		
		return "friend";
	}
	
	
}
