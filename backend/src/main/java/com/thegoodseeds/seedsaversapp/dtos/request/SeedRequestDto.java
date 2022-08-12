package com.thegoodseeds.seedsaversapp.dtos.request;

public class SeedRequestDto {
	
	private String popularName;
	private Integer typeOfStorage;
	 private String seedImg;
	 
	 public SeedRequestDto() {
		 
	 }

	public SeedRequestDto(String popularName, Integer typeOfStorage, String seedImg) {
		this.popularName = popularName;
		this.typeOfStorage = typeOfStorage;
		this.seedImg = seedImg;
	}

	public String getPopularName() {
		return popularName;
	}

	public void setPopularName(String popularName) {
		this.popularName = popularName;
	}

	public Integer getTypeOfStorage() {
		return typeOfStorage;
	}

	public void setTypeOfStorage(Integer typeOfStorage) {
		this.typeOfStorage = typeOfStorage;
	}

	public String getSeedImg() {
		return seedImg;
	}

	public void setSeedImg(String seedImg) {
		this.seedImg = seedImg;
	}

	
	 
}
