package com.thegoodseeds.seedsaversapp.dtos.request;

public class PostRequestDto {
	
    private String title;
    private String postMessage;
    
    public PostRequestDto() {
    	
    }
    
	public PostRequestDto(String title, String postMessage) {
		this.title = title;
		this.postMessage = postMessage;
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
	
}