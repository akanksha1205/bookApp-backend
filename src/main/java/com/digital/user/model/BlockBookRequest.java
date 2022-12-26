package com.digital.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BlockBookRequest {

	@JsonProperty("UserID")
	private Integer userID;
	@JsonProperty("BookID")
	private Integer bookID;
	
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public Integer getBookID() {
		return bookID;
	}
	public void setBookID(Integer bookID) {
		this.bookID = bookID;
	}
	
	
}
