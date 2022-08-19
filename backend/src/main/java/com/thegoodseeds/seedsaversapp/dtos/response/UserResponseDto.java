package com.thegoodseeds.seedsaversapp.dtos.response;

import com.thegoodseeds.seedsaversapp.entities.User;

public class UserResponseDto {

	private String email;
	private String profileImg;

	// Colocar mais atributos

	public UserResponseDto(User user) {
		this.email = user.getUsername();
		this.profileImg = user.getProfileImg();
	}

	public String getEmail() {
		return email;
	}

	public void setUserName(String email) {
		this.email = email;
	}

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
