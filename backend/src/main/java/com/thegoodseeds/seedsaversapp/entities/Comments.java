package com.thegoodseeds.seedsaversapp.entities;

import java.sql.Timestamp;

public class Comments {
	
	   private Long commentID;
	   private Long postId;
	   private String commentMessage;
	   private Timestamp createdtime;
	   
	   public Comments() {
		   
	   }

	public Comments(Long commentID, Long postId, String commentMessage, Timestamp createdtime) {
		super();
		this.commentID = commentID;
		this.postId = postId;
		this.commentMessage = commentMessage;
		this.createdtime = createdtime;
	}

	public Long getCommentID() {
		return commentID;
	}

	public void setCommentID(Long commentID) {
		this.commentID = commentID;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getCommentMessage() {
		return commentMessage;
	}

	public void setCommentMessage(String commentMessage) {
		this.commentMessage = commentMessage;
	}

	public Timestamp getCreatedtime() {
		return createdtime;
	}

	public void setCreatedtime(Timestamp createdtime) {
		this.createdtime = createdtime;
	}
      
	   
}
