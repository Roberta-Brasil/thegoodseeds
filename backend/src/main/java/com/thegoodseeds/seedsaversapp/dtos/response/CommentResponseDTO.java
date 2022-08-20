package com.thegoodseeds.seedsaversapp.dtos.response;

import java.time.LocalDateTime;

import com.thegoodseeds.seedsaversapp.entities.Comment;

public class CommentResponseDTO {

	private String commentMessage;
	private LocalDateTime createdtime;
	private UserResponseDTO user;

	public CommentResponseDTO(Comment comment) {
		this.commentMessage = comment.getCommentMessage();
		this.createdtime = comment.getCreatedtime();
		this.user = new UserResponseDTO(comment.getUser());
	}

	public CommentResponseDTO(javax.xml.stream.events.Comment comment) {
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

	public UserResponseDTO getUser() {
		return user;
	}

	public void setUser(UserResponseDTO user) {
		this.user = user;
	}

}
