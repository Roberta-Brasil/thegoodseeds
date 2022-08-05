package com.thegoodseeds.seedsaversapp.dtos.response;

import com.thegoodseeds.seedsaversapp.entities.User;

public class UserResponseDto {
	
	private String userName;
	private String profileImg;
	
	public UserResponseDto(User user) {
		this.userName = user.getUsername();
		this.profileImg = user.getProfileImg();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	
}
