package com.bigman.blog.bean;

import java.util.List;

public class User_Mapping {

	private int user_id;
	private List<Integer> fan_id;
	private List<Integer> concern_id;
	private List<Integer> blogs;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public List<Integer> getFan_id() {
		return fan_id;
	}
	public void setFan_id(List<Integer> fan_id) {
		this.fan_id = fan_id;
	}
	public List<Integer> getConcern_id() {
		return concern_id;
	}
	public void setConcern_id(List<Integer> concern_id) {
		this.concern_id = concern_id;
	}
	public List<Integer> getBlogs() {
		return blogs;
	}
	public void setBlogs(List<Integer> blogs) {
		this.blogs = blogs;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + user_id;
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
		User_Mapping other = (User_Mapping) obj;
		if (user_id != other.user_id)
			return false;
		return true;
	}
	public User_Mapping(int user_id, List<Integer> fan_id, List<Integer> concern_id, List<Integer> blogs) {
		this.user_id = user_id;
		this.fan_id = fan_id;
		this.concern_id = concern_id;
		this.blogs = blogs;
	}
	public User_Mapping() {
	}
	
	
}
