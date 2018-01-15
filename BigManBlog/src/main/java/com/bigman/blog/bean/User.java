package com.bigman.blog.bean;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	
	private static final long serialVersionUID = 2254791875112953970L;
	private Integer id;
	private String username;
	private String password;
	private String question;
	private String answer;
	private String user_pic;
	private Date regTime;
	
	
	
	
	
	public User() {
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	public String getQuestion() {
		return question;
	}



	public void setQuestion(String question) {
		this.question = question;
	}



	public String getAnswer() {
		return answer;
	}



	public void setAnswer(String answer) {
		this.answer = answer;
	}



	public String getUser_pic() {
		return user_pic;
	}



	public void setUser_pic(String user_pic) {
		this.user_pic = user_pic;
	}



	public Date getRegTime() {
		return regTime;
	}



	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", question=" + question
				+ ", answer=" + answer + ", user_pic=" + user_pic + ", regTime=" + regTime ;
	}



	public User(Integer id, String username, String password, String question, String answer, String user_pic,
			Date regTime) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.question = question;
		this.answer = answer;
		this.user_pic = user_pic;
		this.regTime = regTime;
		
	}



	
	
	
}
