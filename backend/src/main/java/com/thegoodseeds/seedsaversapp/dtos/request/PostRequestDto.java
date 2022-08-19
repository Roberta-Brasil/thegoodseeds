package com.thegoodseeds.seedsaversapp.dtos.request;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

public class PostRequestDto {
	
	@NotBlank
    private String title;
	
	@NotBlank
    private String postMessage;
	
	@Valid
	private SeedIdRequestDto seedIdDto;
    
    public PostRequestDto() {
    	
    }

	public PostRequestDto(@NotBlank String title, @NotBlank String postMessage, @Valid SeedIdRequestDto seedIdDto) {
		this.title = title;
		this.postMessage = postMessage;
		this.seedIdDto = seedIdDto;
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

	public SeedIdRequestDto getSeedIdDto() {
		return seedIdDto;
	}

	public void setSeedIdDto(SeedIdRequestDto seedIdDto) {
		this.seedIdDto = seedIdDto;
	}
    
	
}