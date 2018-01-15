package com.bigman.blog.dao;

import java.util.List;

import com.bigman.blog.bean.Respo2;


public interface Response2Dao {

	/**
	 * 增加到数据库中
	 */
	void addRes2(Respo2 re);
	
	
	/**
	 *  验证是否有权限，并决定是否删除
	 * @param id respo2的id
	 * @param uid 操作人的id
	 * @return 是否删除成功
	 */
	boolean delete(Integer id,Integer uid);
	
	/**
	 *   验证是否有权限，并决定是否修改 
	 * @param re 修改后的respo2
	 * @param uid 操作者的id
	 * @return 是否修改成功
	 */
	boolean alter(Respo2 re,Integer uid);
	
	
	/**
	 * 查看某篇帖子下的所有回复
	 * @param response respo1的id
	 * @return
	 */
	List<Respo2> selectRes2(Integer response);
	
}
