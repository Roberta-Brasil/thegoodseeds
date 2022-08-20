package com.thegoodseeds.seedsaversapp.dtos.request;


import javax.validation.constraints.NotEmpty;

public class SeedIdRequestDTO {

	@NotEmpty
	private Long id;
	
	public SeedIdRequestDTO() {
		
	}
	
	
	public SeedIdRequestDTO(@NotEmpty Long id) {
		this.id = id;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
