package com.thegoodseeds.seedsaversapp.dtos.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thegoodseeds.seedsaversapp.entities.Post;

public class PostResponseDto {
	
	private int likesQuantity;
    private String title;
    private String postMessage;    
    
    @JsonIgnore
    private Long id;
    
	
    public PostResponseDto(Post post) {
     this.likesQuantity = post.getLikesQuantity();
     this.title = post.getTitle();
     this.postMessage = post.getPostMessage();
     this.id=post.getPostId();
    }
    
	public int getLikesQuantity() {
		return likesQuantity;
	}
	public void setLikesQuantity(int likesQuantity) {
		this.likesQuantity = likesQuantity;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPostMessage() {
		return postMessage;
	}
	public void setPostMessage(String postMessage) {
		this.postMessage = postMessage;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "PostRequestDTO [likesQuantity=" + likesQuantity + ", title=" + title + ", postMessage=" + postMessage
				+ "]";
	}

}
