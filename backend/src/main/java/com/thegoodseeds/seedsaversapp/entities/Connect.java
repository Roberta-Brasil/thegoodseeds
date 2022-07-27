package com.thegoodseeds.seedsaversapp.entities;

import java.util.Date;

public class Connect {
	
	   private Long userId;
	   private Long followedId;
	   private Date followAt;
	   private Date updatedAt;
	   
	   
	   public Connect(){
		   
	   }


	public Connect(Long userId, Long followedId, Date followAt, Date updatedAt) {
		super();
		this.userId = userId;
		this.followedId = followedId;
		this.followAt = followAt;
		this.updatedAt = updatedAt;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public Long getFollowedId() {
		return followedId;
	}


	public void setFollowedId(Long followedId) {
		this.followedId = followedId;
	}


	public Date getFollowAt() {
		return followAt;
	}


	public void setFollowAt(Date followAt) {
		this.followAt = followAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	   
	   

}
