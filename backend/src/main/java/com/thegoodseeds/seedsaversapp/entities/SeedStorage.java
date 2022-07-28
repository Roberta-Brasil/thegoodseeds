package com.thegoodseeds.seedsaversapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SeedStorage")
public class SeedStorage {
	
	 @Id
	 @GeneratedValue(strategy =GenerationType.IDENTITY) 
	  private Long storageId;
	  private Long seedId;
	  private String typeStorage;

	  public SeedStorage() {
		  
	  }

	public SeedStorage(Long storageId, Long seedId, String typeStorage) {
		super();
		this.storageId = storageId;
		this.seedId = seedId;
		this.typeStorage = typeStorage;
	}

	public Long getStorageId() {
		return storageId;
	}

	public void setStorageId(Long storageId) {
		this.storageId = storageId;
	}

	public Long getSeedId() {
		return seedId;
	}

	public void setSeedId(Long seedId) {
		this.seedId = seedId;
	}

	public String getTypeStorage() {
		return typeStorage;
	}

	public void setTypeStorage(String typeStorage) {
		this.typeStorage = typeStorage;
	}
	  
	  
}
