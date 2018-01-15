package com.bigman.blog.bean;

import java.sql.Timestamp;
import java.util.Date;

public class Blogs {

	public static final int ORIG_TYPE=1;
	public static final int FORWARD_TYPE=2;
	
	/**
	 * 文章id
	 */
	private Integer tid ;
	/**
	 * 作者id
	 */
	private Integer user_id;
	/**
	 * 文章标题
	 */
	private String title;
	/**
	 * 原创还是转载 ,使用本类常量标记
	 */
	private int type;
	/**
	 * 小标题
	 */
	private String subtitle;
	
	/**
	 * 创建时间
	 */
	private Timestamp create_date;
	/**
	 * 修改时间
	 */
	private Timestamp alter_date;
	/**
	 * 文字html文件保存目录
	 */
	private String file_url;
	
	/**
	 * 一级回复
	 */
	private Response1 res1;
	
	/**
	 * 二级回复
	 */
	private Respo2 res2;
	
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + tid;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Blogs other = (Blogs) obj;
		if (tid != other.tid)
			return false;
		return true;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}
	public Date getAlert_date() {
		return alter_date;
	}
	public void setAlert_date(Timestamp alert_date) {
		this.alter_date = alert_date;
	}
	public String getFile_url() {
		return file_url;
	}
	public void setFile_url(String file_url) {
		this.file_url = file_url;
	}
	
	
	
	public Timestamp getAlter_date() {
		return alter_date;
	}
	public void setAlter_date(Timestamp alter_date) {
		this.alter_date = alter_date;
	}
	public Response1 getRes1() {
		return res1;
	}
	public void setRes1(Response1 res1) {
		this.res1 = res1;
	}
	public Respo2 getRes2() {
		return res2;
	}
	public void setRes2(Respo2 res2) {
		this.res2 = res2;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Blogs(Integer tid, Integer user_id, String title, int type, String subtitle, Timestamp create_date,
			Timestamp alter_date, String file_url, Response1 res1, Respo2 res2) {
		this.tid = tid;
		this.user_id = user_id;
		this.title = title;
		this.type = type;
		this.subtitle = subtitle;
		this.create_date = create_date;
		this.alter_date = alter_date;
		this.file_url = file_url;
		this.res1 = res1;
		this.res2 = res2;
	}
	public Blogs() {
	}
	@Override
	public String toString() {
		return "blogs [tid=" + tid + ", user_id=" + user_id + ", title=" + title + ", type=" + type + ", subtitle="
				+ subtitle + ", create_date=" + create_date + ", alert_date=" + alter_date + ", file_url=" + file_url
				+ "]";
	}
	
	/**
	 * 
	 * @param user_id 用户id
	 * @param title 帖子标题
	 * @param subtitle 副标题
	 * @param file_url 本地文件地址
	 */
	public Blogs( Integer user_id, String title, String subtitle, String file_url) {
		this.user_id = user_id;
		this.title = title;
		this.type = ORIG_TYPE;
		this.subtitle = subtitle;
		this.file_url = file_url;
	}
	
	
	
}
