package com.thegoodseeds.seedsaversapp.dtos.request;

import javax.validation.constraints.NotBlank;

public class SeedRequestDto {
	
	   @NotBlank
	   private String popularName;
	   
	 
	   private String scientificName;
	   private String familyName;
	   
	   @NotBlank
	   private String seedDescription;
	   
	   @NotBlank
	   private String seedImg;
	   
	   @NotBlank
	   private Integer typeOfStorage;
	   
	   @NotBlank
	   private String locationOfCollection;
	   
	   @NotBlank
	   private String dateOfCollection;
	 
	 public SeedRequestDto() {
		 
	 }

	

	public SeedRequestDto(@NotBlank String popularName, String scientificName, String familyName,
			@NotBlank String seedDescription, @NotBlank String seedImg, @NotBlank Integer typeOfStorage) {
		this.popularName = popularName;
		this.scientificName = scientificName;
		this.familyName = familyName;
		this.seedDescription = seedDescription;
		this.seedImg = seedImg;
		this.typeOfStorage = typeOfStorage;
	}



	public String getScientificName() {
		return scientificName;
	}



	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}



	public String getFamilyName() {
		return familyName;
	}



	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}



	public String getSeedDescription() {
		return seedDescription;
	}



	public void setSeedDescription(String seedDescription) {
		this.seedDescription = seedDescription;
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
	
	



	public String getLocationOfCollection() {
		return locationOfCollection;
	}



	public void setLocationOfCollection(String locationOfCollection) {
		this.locationOfCollection = locationOfCollection;
	}



	public String getDateOfCollection() {
		return dateOfCollection;
	}



	public void setDateOfCollection(String dateOfCollection) {
		this.dateOfCollection = dateOfCollection;
	}



	 
}
