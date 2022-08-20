package com.thegoodseeds.seedsaversapp.dtos.request;


public class CommentRequestDTO {
	
    private String message;
    
   public CommentRequestDTO() {
	   
   }
    
	public CommentRequestDTO(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}