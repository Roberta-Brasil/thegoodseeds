package com.thegoodseeds.seedsaversapp.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "Comments")
public class Comments {
	
	   @Id
	   @GeneratedValue(strategy =GenerationType.IDENTITY) 
	   private Long commentID;
	   
	   private String commentMessage;
	   private LocalDateTime createdtime;
	   
	   
	   @ManyToOne
	   @JoinColumn(name = "postId")
	   private Post post;
	   
	   public Comments() {
		   
	   }

	public Comments( String commentMessage) {
		
		this.commentMessage = commentMessage;
		
	}

	public Long getCommentID() {
		return commentID;
	}

	public void setCommentID(Long commentID) {
		this.commentID = commentID;
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

	@PrePersist
	public void setCreatedtime() {
		this.createdtime = LocalDateTime.now();
	}

	@Override
	public String toString() {
		return "Comments [commentID=" + commentID + ", commentMessage=" + commentMessage + ", createdtime="
				+ createdtime + ", post=" + post + "]";
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	

	
	   
}
