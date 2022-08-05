package com.thegoodseeds.seedsaversapp.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_swap")
public class Swap {
	
	   @Id
	   @GeneratedValue(strategy =GenerationType.IDENTITY) 
	   private Long swapId;
	   private LocalDate swapDate;
	   private int seedQuantity;  
	   
	   public Swap() {}

	public Swap(Long swapId, LocalDate swapDate, int seedQuantity) {
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

	public LocalDate getSwapDate() {
		return swapDate;
	}

	public void setSwapDate(LocalDate swapDate) {
		this.swapDate = swapDate;
	}

	public int getSeedQuantity() {
		return seedQuantity;
	}

	public void setSeedQuantity(int seedQuantity) {
		this.seedQuantity = seedQuantity;
	}

		   
	   
}
