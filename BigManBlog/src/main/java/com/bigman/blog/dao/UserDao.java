package com.bigman.blog.dao;

import org.apache.ibatis.annotations.Param;

import com.bigman.blog.bean.User;


public interface UserDao {

	/**
	 * 将用户信息增加到数据库中
	 * user的ID是自动生成的.
	 * @param user 是用户信息
	 */
	Integer addUser(User user);
	
	/**
	 * 从相关表中删除用户数据
	 * @param table 与用户相关的有users_info，users，blogs
	 * @param id
	 * @return
	 */
	Integer deleteUser (String table, int id) ;
	
	/**
	 * 改
	 */
	Integer alterUser(Integer id);
	
	/**
	 * 查
	 */
	User showUser(int id);
	
	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return 数据库中的User信息，没有则为null
	 */
	User findUserByName(String username);
	
	/**
	 * 根据id修改头像
	 * @param id
	 * @return
	 */
	Integer changePortrait(@Param("id")Integer id,@Param("user_pic")String user_pic);
	
	
	
	
	
	
	
	
	
}
