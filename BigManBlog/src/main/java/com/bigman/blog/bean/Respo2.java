package com.bigman.blog.bean;

import java.util.Date;

public class Respo2 {

	private Integer id ;
	private Integer response ;
	private Integer user_id;
	private String text ;
	private Date time ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getResponse() {
		return response;
	}
	public void setResponse(Integer response) {
		this.response = response;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Respo2 other = (Respo2) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Resposne2 [id=" + id + ", response=" + response + ", user_id=" + user_id + ", text=" + text + ", time="
				+ time + "]";
	}
	public Respo2(Integer id, Integer response, Integer user_id, String text, Date time) {
		this.id = id;
		this.response = response;
		this.user_id = user_id;
		this.text = text;
		this.time = time;
	}
	public Respo2() {
	}
	
	
	
}
