package com.thegoodseeds.seedsaversapp.entities;

import java.util.Date;

public class WishList {
	
	   private Long wishListId;
	   private String wishListName;
	   private Long seedId;
	   private Long userId;
	   private Date creationDate;
	   
	   public WishList() {
		   
	   }

	public WishList(Long wishListId, String wishListName, Long seedId, Long userId, Date creationDate) {
		super();
		this.wishListId = wishListId;
		this.wishListName = wishListName;
		this.seedId = seedId;
		this.userId = userId;
		this.creationDate = creationDate;
	}

	public Long getWishListId() {
		return wishListId;
	}

	public void setWishListId(Long wishListId) {
		this.wishListId = wishListId;
	}

	public String getWishListName() {
		return wishListName;
	}

	public void setWishListName(String wishListName) {
		this.wishListName = wishListName;
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

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	   
	   

}
