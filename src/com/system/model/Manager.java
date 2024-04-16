package com.system.model;

public class Manager {
	private int sid;
	private String mName;
	private String password;
	
	public Manager() {
		super();
	}
	
	public Manager(String mName, String password) {
		super();
		this.mName = mName;
		this.password = password;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
