package com.thegoodseeds.seedsaversapp.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thegoodseeds.seedsaversapp.entities.User;

public class UserDTO {

	private String name;

	@JsonIgnore
	private String password;
	private String email;
	private String fullName;
	private String userAddress;
	private String profileImg;
	private String phoneNumber;

	// IMpossibilitar esse atributo vim do json
	// ---------------------------------//
	private LocalDateTime creationDate;
	private LocalDateTime changeDate;
	
//	@Column(name = "reset_password_token")
//    private String resetPasswordToken;

	public UserDTO() {

	}

	public UserDTO(User user) {
		this.name = user.getName();
		this.email = user.getEmail();
		this.fullName = user.getFullName();
		this.userAddress = user.getUserAddress();
		this.profileImg = user.getProfileImg();
		this.phoneNumber = user.getPhoneNumber();
		this.changeDate = user.getChangeDate();
	}

	public UserDTO(String name, String password, String email, String fullName, String userAddress, String profileImg,
			String phoneNumber, LocalDateTime creationDate, LocalDateTime changeDate) {
		this.name = name;
		this.password = password;
		this.email = email;
		this.fullName = fullName;
		this.userAddress = userAddress;
		this.profileImg = profileImg;
		this.phoneNumber = phoneNumber;
		this.creationDate = creationDate;
		this.changeDate = changeDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public LocalDateTime getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(LocalDateTime changeDate) {
		this.changeDate = changeDate;
	}

//	public String getResetPasswordToken() {
//		return resetPasswordToken;
//	}
//
//	public void setResetPasswordToken(String resetPasswordToken) {
//		this.resetPasswordToken = resetPasswordToken;
//	}
	
	

}
