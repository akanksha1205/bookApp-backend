	package com.digital.user.model;

	import com.fasterxml.jackson.annotation.JsonProperty;

	public class EditBookResponse {

		@JsonProperty("bookId")
		private Integer bookId;
		
		@JsonProperty("successMsg")
		private String successMsg;
		
		@JsonProperty("errorInfo")
		private ErrorInfo errorInfo;

		public Integer getBookId() {
			return bookId;
		}

		public void setBookId(Integer bookId) {
			this.bookId = bookId;
		}

		public String getSuccessMsg() {
			return successMsg;
		}

		public void setSuccessMsg(String successMsg) {
			this.successMsg = successMsg;
		}

		public ErrorInfo getErrorInfo() {
			return errorInfo;
		}

		public void setErrorInfo(ErrorInfo errorInfo) {
			this.errorInfo = errorInfo;
		}

		
		
		
		
	}

