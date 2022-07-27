package com.thegoodseeds.seedsaversapp.entities;

public class Seed {
	
	   private Long seedId;
	   private String popularName;
	   private String scientificName;
	   private String familyName;
	   private String seedStorage;
	   private String seedDescription;
	   private String seedImg;
	   
	   public Seed() {		   
	   }

	public Seed(Long seedId, String popularName, String scientificName, String familyName, String seedStorage,
			String seedDescription, String seedImg) {
		super();
		this.seedId = seedId;
		this.popularName = popularName;
		this.scientificName = scientificName;
		this.familyName = familyName;
		this.seedStorage = seedStorage;
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

	public String getSeedStorage() {
		return seedStorage;
	}

	public void setSeedStorage(String seedStorage) {
		this.seedStorage = seedStorage;
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
