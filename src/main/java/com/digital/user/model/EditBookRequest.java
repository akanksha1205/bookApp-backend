package com.digital.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EditBookRequest {

	@JsonProperty("UserID")
	private Integer userID;
	
	@JsonProperty("BookID")
	private Integer bookID;

	@JsonProperty("book")
	private Book book;
	
	
	
	public Integer getBookID() {
		return bookID;
	}

	public void setBookID(Integer bookID) {
		this.bookID = bookID;
	}

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
