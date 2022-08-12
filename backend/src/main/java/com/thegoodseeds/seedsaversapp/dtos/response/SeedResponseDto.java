package com.thegoodseeds.seedsaversapp.dtos.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thegoodseeds.seedsaversapp.entities.Seed;
import com.thegoodseeds.seedsaversapp.enums.TypeOfStorage;

public class SeedResponseDto {
	
	   private String popularName;
	   private String scientificName;
	   private String familyName;
	   private String seedDescription;
	   private String seedImg;
	   
	   private TypeOfStorage typeOfStorage;
	   
	   
	   @JsonIgnore
	    private Long id;
	   
	   public SeedResponseDto(Seed seed) {
		 this.popularName = seed.getPopularName();
		   this.scientificName = seed.getScientificName();
		   this.familyName = seed.getFamilyName();
		   this.seedDescription = seed.getSeedDescription();
		   this.seedImg = seed.getSeedImg();
		   this.id = seed.getSeedId();
		   this.typeOfStorage = seed.getTypeOfStorage();
	   }
	   
	   
	   
public TypeOfStorage getTypeOfStorage() {
	return this.typeOfStorage;
}


	public Long getId() {
		return id;
	}




	public String getPopularName() {
		return popularName;
	}


	public String getScientificName() {
		return scientificName;
	}

	

	public String getFamilyName() {
		return familyName;
	}

	

	public String getSeedDescription() {
		return seedDescription;
	}


	public String getSeedImg() {
		return seedImg;
	}

 
	   

}
