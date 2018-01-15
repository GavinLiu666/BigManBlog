package com.bigman.blog.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bigman.blog.bean.User_info;


public interface UserInfoDao {
	
	
	/**
	 * 将用户信息保存到数据库中
	 * user的ID是自动生成的.
	 * @param user 是用户信息
	 */
	Integer saveUser(User_info user);
	
	/**
	 * 查询一个页面的全部user信息
	 * @param start 起始行数
	 * @param size  页面大小
	 * @return 一个页面的数据
	 */
	List<User_info> findAllByPage(int start, int size);
	
	/**
	 * 计算全部的行数
	 * @return
	 */
	Integer countAll();
	
	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return 数据库中的User信息，没有则为null
	 */
	User_info findUserInfoByName(String username);
	
	/**
	 * myId关注了friendNameId则为1
	 * 如果myId没有关注对方则为0
	 */
	Integer isAttendFans(@Param("myId")Integer myId, @Param("attendId")Integer attendId);
	
	/**
	 * myName关注friendName
	 * @param myNameId
	 * @param friendNameId
	 */
	Integer addAttend(@Param("myId")Integer myId, @Param("friendId")Integer friendId);
	
	/**
	 * myName取关friendName
	 * @param id
	 * @return
	 */
	Integer cancelAttend(@Param("myId")Integer myId, @Param("friendId")Integer friendId);
	
	
	Integer deleteById(Integer id);
	
	
	
	
}








