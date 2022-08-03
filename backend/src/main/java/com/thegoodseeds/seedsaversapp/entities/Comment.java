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
import javax.persistence.Transient;

@Entity
@Table(name = "Comments")
public class Comment {
	
	   @Id
	   @GeneratedValue(strategy =GenerationType.IDENTITY) 
	   private Long commentID;
	   
	   private String commentMessage;
	   private LocalDateTime createdtime;
	   
	   @Transient
	   @ManyToOne
	   @JoinColumn(name = "postId")
	   private Post post;
	   
	   @Transient
	   @ManyToOne
	   @JoinColumn(name = "userId")
	   private User user;

	   
	   public Comment() {
		   
	   }

	public Comment( String commentMessage) {
		
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


	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Comment [commentID=" + commentID + ", commentMessage=" + commentMessage + ", createdtime=" + createdtime
				+ ", post=" + post + ", user=" + user + "]";
	}
	
	


	

	
	   
}
