package com.bigman.blog.bean;

import java.util.Date;

public class Response1 {

	private StringBuilder text;
	private int post_id;
	private int user_id;
	private int tid;
	private int respond;
	private Date time ;
	public StringBuilder getText() {
		return text;
	}
	public void setText(StringBuilder text) {
		this.text = text;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getRespond() {
		return respond;
	}
	public void setRespond(int respond) {
		this.respond = respond;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Response1 [text=" + text + ", post_id=" + post_id + ", user_id=" + user_id + ", tid=" + tid
				+ ", respond=" + respond + ", time=" + time + "]";
	}
	public Response1(StringBuilder text, int post_id, int user_id, int tid, int respond, Date time) {
		super();
		this.text = text;
		this.post_id = post_id;
		this.user_id = user_id;
		this.tid = tid;
		this.respond = respond;
		this.time = time;
	}
	public Response1() {
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + post_id;
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
		Response1 other = (Response1) obj;
		if (post_id != other.post_id)
			return false;
		return true;
	}
	
	
}
