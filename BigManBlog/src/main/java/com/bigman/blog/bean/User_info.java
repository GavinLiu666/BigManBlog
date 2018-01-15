package com.bigman.blog.bean;

import java.io.Serializable;
import java.util.Date;


public class User_info implements Serializable {

	private static final long serialVersionUID = 2254791875112953970L;
	private Integer id;
	private String username;
	private String email;
	private String mobile;
	private char sex;
	private Date birthday;
	private String icon;// 用户头像路径
	private Integer blogs;// 用户博客数量
	private Integer attend;// 用户关注的数量
	private Integer fans;// 用户粉丝的数量

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	private Date createTime;

	public User_info() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
		User_info other = (User_info) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public User_info(Integer id, String username, String email, String mobile, char sex, Date birthday,
			Date createTime) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.mobile = mobile;
		this.sex = sex;
		this.birthday = birthday;
		this.createTime = createTime;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getBlogs() {
		return blogs;
	}

	public void setBlogs(Integer blogs) {
		this.blogs = blogs;
	}

	public Integer getAttend() {
		return attend;
	}

	public void setAttend(Integer attend) {
		this.attend = attend;
	}

	public Integer getFans() {
		return fans;
	}

	public void setFans(Integer fans) {
		this.fans = fans;
	}

	@Override
	public String toString() {
		return "User_info [id=" + id + ", username=" + username + ", email=" + email + ", mobile=" + mobile + ", sex="
				+ sex + ", birthday=" + birthday + ", icon=" + icon + ", blogs=" + blogs + ", attend=" + attend
				+ ", fans=" + fans + ", createTime=" + createTime + "]";
	}




}
