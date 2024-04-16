package com.system.model;

/**
 * 用户实体
 */

public class User {
	private String sid;
	private String name;
	private String password;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String sid, String name, String password) {
		super();
		this.sid = sid;
		this.name = name;
		this.password = password;
	}

	public User(String sid, String password) {
		super();
		this.sid = sid;
		this.password = password;
	}

	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
