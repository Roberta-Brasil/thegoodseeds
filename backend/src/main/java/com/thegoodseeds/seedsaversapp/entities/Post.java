package com.thegoodseeds.seedsaversapp.entities;

import java.security.Timestamp;

public class Post {
	
	   private Long postId;
	   private Timestamp timePost;
	   private int likesQuantity;
	   private String postMessage;
	   private Long seedId;
	   private Long userId;
	   
	   public Post() {
		   
	   }

	public Post(Long postId, Timestamp timePost, int likesQuantity, String postMessage, Long seedId, Long userId) {
		super();
		this.postId = postId;
		this.timePost = timePost;
		this.likesQuantity = likesQuantity;
		this.postMessage = postMessage;
		this.seedId = seedId;
		this.userId = userId;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public Timestamp getTimePost() {
		return timePost;
	}

	public void setTimePost(Timestamp timePost) {
		this.timePost = timePost;
	}

	public int getLikesQuantity() {
		return likesQuantity;
	}

	public void setLikesQuantity(int likesQuantity) {
		this.likesQuantity = likesQuantity;
	}

	public String getPostMessage() {
		return postMessage;
	}

	public void setPostMessage(String postMessage) {
		this.postMessage = postMessage;
	}

	public Long getSeedId() {
		return seedId;
	}

	public void setSeedId(Long seedId) {
		this.seedId = seedId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	   
	   

}
