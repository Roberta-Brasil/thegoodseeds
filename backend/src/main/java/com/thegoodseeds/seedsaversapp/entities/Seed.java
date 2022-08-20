package com.thegoodseeds.seedsaversapp.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.thegoodseeds.seedsaversapp.enums.TypeOfStorage;

@Entity
@Table(name = "tb_seed")
public class Seed {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seedId;
	private String popularName;
	private String scientificName;
	private String familyName;
	private String seedDescription;
	private String seedImg;
	private String locationOfCollection;
	private LocalDate dateOfCollection;

	private Integer typeOfStorage;

	@ManyToOne
	private User user;

//	@Transient()
//	@JsonIgnore()
	@OneToOne(mappedBy = "seed", cascade = CascadeType.ALL)
	private Post post;

	public Seed() {

	}

	public Seed(String popularName, String scientificName, String familyName, TypeOfStorage typeOfStorage,
			String seedDescription, String seedImg, String locationOfCollection, LocalDate dateOfCollection) {

		this.popularName = popularName;
		this.scientificName = scientificName;
		this.familyName = familyName;
		setTypeOfStorage(typeOfStorage);
		this.seedDescription = seedDescription;
		this.seedImg = seedImg;
		this.locationOfCollection = locationOfCollection;
		this.dateOfCollection = dateOfCollection;
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

	public String getLocationOfCollection() {
		return locationOfCollection;
	}

	public void setLocationOfCollection(String locationOfCollection) {
		this.locationOfCollection = locationOfCollection;
	}

	public LocalDate getDateOfCollection() {
		return dateOfCollection;
	}

	public void setDateOfCollection(LocalDate dateOfCollection) {
		this.dateOfCollection = dateOfCollection;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "Seed [seedId=" + seedId + ", popularName=" + popularName + ", scientificName=" + scientificName
				+ ", familyName=" + familyName + ", seedDescription=" + seedDescription + ", seedImg=" + seedImg
				+ ", typeOfStorage=" + typeOfStorage + "]";
	}

}
