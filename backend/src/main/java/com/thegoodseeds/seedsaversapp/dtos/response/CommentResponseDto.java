package com.thegoodseeds.seedsaversapp.dtos.response;

import java.time.LocalDateTime;

import com.thegoodseeds.seedsaversapp.entities.Comment;


public class CommentResponseDto {
	
	  
	   private String commentMessage;
	   private LocalDateTime createdtime;
	   private UserResponseDto user;
	
	   public CommentResponseDto(Comment comment) {
		 this.commentMessage = comment.getCommentMessage();
	     this.createdtime = comment.getCreatedtime();
	     this.user = new UserResponseDto(comment.getUser());
	   }

	public CommentResponseDto(javax.xml.stream.events.Comment comment) {
		// TODO Auto-generated constructor stub
	}

	public String getCommentMessage() {
		return commentMessage;
	}

	public void setCommentMessage(String commentMessage) {
		this.commentMessage = commentMessage;
	}

	public LocalDateTime getCreatedtime() {
		return createdtime;
	}

	public void setCreatedtime(LocalDateTime createdtime) {
		this.createdtime = createdtime;
	}

	public UserResponseDto getUser() {
		return user;
	}

	public void setUser(UserResponseDto user) {
		this.user = user;
	}
	   
	  
}
