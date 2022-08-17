package com.thegoodseeds.seedsaversapp.dtos.response;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.thegoodseeds.seedsaversapp.entities.Seed;
import com.thegoodseeds.seedsaversapp.entities.User;

public class UserResponseDto {
	
	private String email;
	private String profileImg;
	private String name;
	
	private List<SeedResponseDto> seedsDto = new ArrayList<>(); 
	
	public UserResponseDto(User user) {
		this.email= user.getUsername();
		this.profileImg = user.getProfileImg();
		this.name = user.getName();
		this.seedsDto = convertList(user.getSeeds());
	}
	
	private List<SeedResponseDto> convertList(List<Seed> seeds) {
		return seeds.stream().map(SeedResponseDto::new).collect(Collectors.toList());
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SeedResponseDto> getSeedsDto() {
		return seedsDto;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
}
