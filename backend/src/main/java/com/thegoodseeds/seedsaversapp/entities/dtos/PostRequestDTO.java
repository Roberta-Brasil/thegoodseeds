package com.thegoodseeds.seedsaversapp.entities.dtos;

public class PostRequestDTO {
	
    private int likesQuantity;
    private String title;
    private String postMessage;
	public PostRequestDTO(int likesQuantity, String title, String postMessage) {
		super();
		this.likesQuantity = likesQuantity;
		this.title = title;
		this.postMessage = postMessage;
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
	@Override
	public String toString() {
		return "PostRequestDTO [likesQuantity=" + likesQuantity + ", title=" + title + ", postMessage=" + postMessage
				+ "]";
	}
    
    
}