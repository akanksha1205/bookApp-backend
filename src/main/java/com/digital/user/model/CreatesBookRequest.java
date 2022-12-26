package com.digital.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreatesBookRequest {

	@JsonProperty("UserID")
	private Integer userID;

	@JsonProperty("book")
	private Book book;
	
	
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	
	
}
