package com.thegoodseeds.seedsaversapp.dtos.request;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

public class PostRequestDTO {
	
	@NotBlank
    private String title;
	
	@NotBlank
    private String postMessage;
	
	@Valid
	private SeedIdRequestDTO seedIdDto;
    
    public PostRequestDTO() {
    	
    }

	public PostRequestDTO(@NotBlank String title, @NotBlank String postMessage, @Valid SeedIdRequestDTO seedIdDto) {
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

	public SeedIdRequestDTO getSeedIdDto() {
		return seedIdDto;
	}

	public void setSeedIdDto(SeedIdRequestDTO seedIdDto) {
		this.seedIdDto = seedIdDto;
	}
    
	
}