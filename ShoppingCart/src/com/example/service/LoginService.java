package com.example.service;

import com.example.domain.User;

public class LoginService {
	
	
	
	public LoginService() 
	{
		
	}
	
	public LoginService(String userName, String password) 
	{
		
	}
	
	public Boolean authenticate(String userName , String password) 
	{
		
		return userName != null && userName.trim().equals("java") && password !=null && password.trim().equals("java");
		
	}

}
