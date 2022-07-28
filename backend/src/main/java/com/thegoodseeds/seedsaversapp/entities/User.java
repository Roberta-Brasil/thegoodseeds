package com.thegoodseeds.seedsaversapp.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
    
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY) 
	private Long userId;
	private String username;
	private String password;
	private String usermail;
	private String oldPassword;
	private String fullName;
	private String userAddress;
	private String profileImg;
	private Date creationDate;
	private Date changeDate;
	private String phoneNumber;

	public User() {
	}

	public User(Long userId, String username, String password, String usermail, String oldPassword, String fullName,
			String userAddress, String profileImg, Date creationDate, Date changeDate, String phoneNumber) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.usermail = usermail;
		this.oldPassword = oldPassword;
		this.fullName = fullName;
		this.userAddress = userAddress;
		this.profileImg = profileImg;
		this.creationDate = creationDate;
		this.changeDate = changeDate;
		this.phoneNumber = phoneNumber;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsermail() {
		return usermail;
	}

	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
}
