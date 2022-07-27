package com.thegoodseeds.seedsaversapp.entities;

import java.util.Date;

public class Swap {
	
	   private Long swapId;
	   private Date swapDate;
	   private int seedQuantity;  
	   
	   public Swap() {}

	public Swap(Long swapId, Date swapDate, int seedQuantity) {
		super();
		this.swapId = swapId;
		this.swapDate = swapDate;
		this.seedQuantity = seedQuantity;
	}

	public Long getSwapId() {
		return swapId;
	}

	public void setSwapId(Long swapId) {
		this.swapId = swapId;
	}

	public Date getSwapDate() {
		return swapDate;
	}

	public void setSwapDate(Date swapDate) {
		this.swapDate = swapDate;
	}

	public int getSeedQuantity() {
		return seedQuantity;
	}

	public void setSeedQuantity(int seedQuantity) {
		this.seedQuantity = seedQuantity;
	}
	   
	   
}
