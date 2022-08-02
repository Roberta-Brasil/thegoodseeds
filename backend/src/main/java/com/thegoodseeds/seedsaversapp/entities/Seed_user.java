package com.thegoodseeds.seedsaversapp.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.thegoodseeds.seedsaversapp.enums.SeedStatus;

@Entity
@Table(name = "Seed_user")
public class Seed_user {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seedId;
	private Long userId;
	private String locationOfCollenction;
	private LocalDate dateOfCollection;

	// I used the datatype integer to do not break the application..see enums
	// SeedStatus!
	private Integer seedStatus;

	public Seed_user() {

	}

	public Seed_user(Long seedId, Long userId, String locationOfCollenction, LocalDate dateOfCollection,
			SeedStatus seedStatus) {

		this.seedId = seedId;
		this.userId = userId;
		this.locationOfCollenction = locationOfCollenction;
		this.dateOfCollection = dateOfCollection;
		setSeedStatus(seedStatus); // this set the seed status that i am receiving!
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

	public SeedStatus getSeedStatus() {
		return SeedStatus.valueOf(seedStatus);
	}

	public void setSeedStatus(SeedStatus seedStatus) {
		if (seedStatus != null) { // verify the order status is valid
			this.seedStatus = seedStatus.getCode();
		}

	}
}
