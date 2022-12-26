package com.digital.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SignInResponse {

	@JsonProperty(value = "SuccessMessage")
	private String successMessage;
	@JsonProperty(value = "UserType")
	private String userType;
	@JsonProperty(value = "errorInfo")
	private ErrorInfo errorInfo;
	
	@JsonProperty(value = "UserID")
	private String userId;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getSuccessMessage() {
		return successMessage;
	}
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
	public ErrorInfo getErrorInfo() {
		return errorInfo;
	}
	public void setErrorInfo(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}
	
	
	
}
