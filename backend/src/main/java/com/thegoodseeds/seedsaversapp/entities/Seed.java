package com.thegoodseeds.seedsaversapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.thegoodseeds.seedsaversapp.enums.TypeOfStorage;

@Entity
@Table(name = "Seed")
public class Seed {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY) 
	   private Long seedId;
	   private String popularName;
	   private String scientificName;
	   private String familyName;
	   private String seedDescription;
	   private String seedImg;
	   
	   private Integer typeOfStorage;
	   
	   public Seed() {		   
	   }

	public Seed(Long seedId, String popularName, String scientificName, String familyName, TypeOfStorage typeOfStorage,
			String seedDescription, String seedImg) {
		
		this.seedId = seedId;
		this.popularName = popularName;
		this.scientificName = scientificName;
		this.familyName = familyName;
		setTypeOfStorage(typeOfStorage); 
		this.seedDescription = seedDescription;
		this.seedImg = seedImg;
	}

	public Long getSeedId() {
		return seedId;
	}

	public void setSeedId(Long seedId) {
		this.seedId = seedId;
	}

	public String getPopularName() {
		return popularName;
	}

	public void setPopularName(String popularName) {
		this.popularName = popularName;
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

	public TypeOfStorage getTypeOfStorage() {
		return TypeOfStorage.valueOf(typeOfStorage);
	}

	public void setTypeOfStorage(TypeOfStorage typeOfStorage) {
		if (typeOfStorage != null) { // verify the typeOfStorage is valid.
			this.typeOfStorage = typeOfStorage.getCodeType();
		}
	}

	public String getSeedDescription() {
		return seedDescription;
	}

	public void setSeedDescription(String seedDescription) {
		this.seedDescription = seedDescription;
	}

	public String getSeedImg() {
		return seedImg;
	}

	public void setSeedImg(String seedImg) {
		this.seedImg = seedImg;
	}
	   
	   
}
