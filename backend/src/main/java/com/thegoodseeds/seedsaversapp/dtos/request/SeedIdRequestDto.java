package com.thegoodseeds.seedsaversapp.dtos.request;


import javax.validation.constraints.NotEmpty;

public class SeedIdRequestDto {

	@NotEmpty
	private Long id;
	
	public SeedIdRequestDto() {
		
	}
	
	
	public SeedIdRequestDto(@NotEmpty Long id) {
		this.id = id;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
