package com.thegoodseeds.seedsaversapp.dtos.request;

public class FilterRequestPostDTO {
	
	
	private String popularName;
	private String scientificName;
	private String familyName;
	private Integer typeOfStorage;
	private String dateOfCollection;
	
	public FilterRequestPostDTO() {
		super();
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

	public Integer getTypeOfStorage() {
		return typeOfStorage;
	}

	public void setTypeOfStorage(Integer typeOfStorage) {
		this.typeOfStorage = typeOfStorage;
	}

	public String getDateOfCollection() {
		return dateOfCollection;
	}

	public void setDateOfCollection(String dateOfCollection) {
		this.dateOfCollection = dateOfCollection;
	}
	
		

}
