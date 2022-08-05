package com.thegoodseeds.seedsaversapp.dtos.request;


public class CommentRequestDto {
	
    private String message;
    
   public CommentRequestDto() {
	   
   }
    
	public CommentRequestDto(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}