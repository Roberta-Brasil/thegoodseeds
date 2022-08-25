package com.thegoodseeds.seedsaversapp.dtos.response;

import java.time.LocalDate;

import com.thegoodseeds.seedsaversapp.entities.Seed;
import com.thegoodseeds.seedsaversapp.enums.TypeOfStorage;

public class SeedResponseDTO {

	private Long id;
	private String popularName;
	private String scientificName;
	private String familyName;
	private String seedDescription;
	private String seedImg;

	private TypeOfStorage typeOfStorage;

	private String locationOfCollection;
	private LocalDate dateOfCollection;

	public SeedResponseDTO(Seed seed) {
		this.popularName = seed.getPopularName(); // !!!!!!!!!!!!!
		this.scientificName = seed.getScientificName();
		this.familyName = seed.getFamilyName();
		this.seedDescription = seed.getSeedDescription();
		this.seedImg = seed.getSeedImg();
		this.id = seed.getSeedId();
		this.typeOfStorage = seed.getTypeOfStorage();
		this.locationOfCollection = seed.getLocationOfCollection();
		this.dateOfCollection = seed.getDateOfCollection();
	}

	public Long getId() {
		return id;
	}

	public TypeOfStorage getTypeOfStorage() {
		return this.typeOfStorage;
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

	public String getLocationOfCollection() {
		return locationOfCollection;
	}

	public LocalDate getDateOfCollection() {
		return dateOfCollection;
	}

}
