package com.digital.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SignInRequest {
	
	@JsonProperty("UserName")
	private String userName;
	@JsonProperty("Password")
	private String password;

	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
