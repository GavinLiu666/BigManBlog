package com.bigman.blog.dao;

import java.util.List;

import com.bigman.blog.bean.Blogs;


public interface BlogDao {

	/**
	 * 增加一篇文章
	 * @param blog
	 */
	void addBlog(Blogs blog);
	
	/**
	 * 删除一篇文章
	 * @param tid
	 */
	void deleteBlog(int tid);
	
	
	/**
	 * 修改某篇文章
	 * @param tid
	 * @return
	 */
	Blogs changBlog(int tid);
	
	/**
	 * 查看一个用户的所有博客
	 * @param user_id
	 * @return
	 */
	List<Blogs> listBlogs(int user_id);
	
	
	
}
