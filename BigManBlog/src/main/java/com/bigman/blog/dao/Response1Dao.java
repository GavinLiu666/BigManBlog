package com.bigman.blog.dao;

import com.bigman.blog.bean.Response1;

public interface Response1Dao {

	/**
	 * 通过博客标题查找一级回复
	 * @param tid
	 * @return
	 */
	Response1 findByTid(int tid) ;	
	
	/**
	 * 验证用户是否为帖子作者或者res1作者，如果有权限，则删除id为post_id的res1
	 * @param post_id res1唯一标识
	 * @param user_id 用户id
	 * @return 是否成功
	 */
	boolean deleteRes1(int post_id, int uid);
	
	/**
	 * 验证用户是否为帖子作者或者res1作者，如果有权限，则修改id为post_id的res1
	 * @param post_id res1唯一标识
	 * @param user_id 用户id
	 * @return 修改过的Res1
	 */
	Response1 alterRes1(int post_id,int uid);
	
}
