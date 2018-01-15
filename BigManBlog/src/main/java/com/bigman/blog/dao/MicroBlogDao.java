package com.bigman.blog.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bigman.blog.bean.MicroBlog;


public interface MicroBlogDao {

	/**
	 * 增加一篇微博
	 * @param blog
	 */
	Integer addBlog(MicroBlog blog);
	
	/**
	 * 删除一篇微博
	 * @param tid
	 */
	Integer deleteBlog(int tid);
	
	/**
	 * 安用户id查找微博
	 * @param uid
	 * @return
	 */
	List<MicroBlog> selectMicroBlog(@Param("uid")int uid);

	
	
	
}
