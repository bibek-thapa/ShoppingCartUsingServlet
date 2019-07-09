package com.example.domain;

public class User {
	
	int id;
	String userName;
	String password;
	public int getId() {
		return id;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", userName=" + userName + ", password=" + password + "]";
	}
	
	
	

}
