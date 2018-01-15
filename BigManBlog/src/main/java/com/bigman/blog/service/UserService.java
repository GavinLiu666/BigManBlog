package com.bigman.blog.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bigman.blog.bean.User_info;


public interface UserService {

	/**
	 * 登录
	 * @param username
	 * @param password
	 * @param session
	 * @return
	 */
	public String login(String username,String password,HttpSession session) ;
	
	/**
	 * 上传用户头像
	 * @param request
	 * @param response
	 * @return
	 */
	String upload(HttpServletRequest request,HttpServletResponse response);
	
	/**
	 * 显示用户的homepage
	 * @param session
	 */
	void showHomePage(HttpSession session);
	
	/**
	 * 增加关注 
	 * @param friendId 要关注的认
	 * @return
	 */
	boolean addAttend(Integer friendId,HttpSession session);
	
	
	/**
	 * 取消关注
	 * @param friendId
	 * @param session
	 * @return
	 */
	boolean rmAttend(Integer friendId,HttpSession session);
	
	
	/**
	 * 通过用户名查找用户的User_info
	 * @param name
	 * @return
	 */
	User_info findUserInfoByName(String name);
	
	/**
	 * 检查是否已经关注对方
	 * @param myId
	 * @param attendId
	 * @return
	 */
	boolean isAttend(Integer myId,Integer attendId,HttpSession session);
	
	
	
	
}
