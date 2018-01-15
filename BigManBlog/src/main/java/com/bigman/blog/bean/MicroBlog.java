package com.bigman.blog.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class MicroBlog implements Serializable{

	private static final long serialVersionUID = 1302973022770080785L;
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
	 * 原创还是转载 ,使用本类常量标记
	 */
	private int type;
	
	/**
	 * 创建时间
	 */
	private Timestamp create_time;
	
	/**
	 * 正文
	 */
	private String text;

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Timestamp getcreate_time() {
		return create_time;
	}

	public void setcreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public static int getOrigType() {
		return ORIG_TYPE;
	}

	public static int getForwardType() {
		return FORWARD_TYPE;
	}

	@Override
	public String toString() {
		return "MicroBlog [tid=" + tid + ", user_id=" + user_id + ", type=" + type + ", create_time=" + create_time
				+ ", text=" + text + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tid == null) ? 0 : tid.hashCode());
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
		MicroBlog other = (MicroBlog) obj;
		if (tid == null) {
			if (other.tid != null)
				return false;
		} else if (!tid.equals(other.tid))
			return false;
		return true;
	}

	public MicroBlog(Integer tid, Integer user_id, int type, Timestamp create_time, String text) {
		this.tid = tid;
		this.user_id = user_id;
		this.type = type;
		this.create_time = create_time;
		this.text = text;
	}

	public MicroBlog() {
	}
	
	
	
}
