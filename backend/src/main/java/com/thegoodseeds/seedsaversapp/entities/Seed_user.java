package com.thegoodseeds.seedsaversapp.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Seed_user")
public class Seed_user {
    
	 @Id
	 @GeneratedValue(strategy =GenerationType.IDENTITY) 
	private Long seedId;
	private Long userId;
	private String locationOfCollenction;
	private LocalDate dateOfCollection;
	private String seedStatus;

	public Seed_user() {

	}

	public Seed_user(Long seedId, Long userId, String locationOfCollenction, LocalDate dateOfCollection,
			String seedStatus) {
		super();
		this.seedId = seedId;
		this.userId = userId;
		this.locationOfCollenction = locationOfCollenction;
		this.dateOfCollection = dateOfCollection;
		this.seedStatus = seedStatus;
	}

	public Long getSeedId() {
		return seedId;
	}

	public void setSeedId(Long seedId) {
		this.seedId = seedId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getLocationOfCollenction() {
		return locationOfCollenction;
	}

	public void setLocationOfCollenction(String locationOfCollenction) {
		this.locationOfCollenction = locationOfCollenction;
	}

	public LocalDate getDateOfCollection() {
		return dateOfCollection;
	}

	public void setDateOfCollection(LocalDate dateOfCollection) {
		this.dateOfCollection = dateOfCollection;
	}

	public String getSeedStatus() {
		return seedStatus;
	}

	public void setSeedStatus(String seedStatus) {
		this.seedStatus = seedStatus;
	}
   
	
}
