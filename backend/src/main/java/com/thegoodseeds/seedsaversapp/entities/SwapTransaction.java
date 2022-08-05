package com.thegoodseeds.seedsaversapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_swap_transaction")
public class SwapTransaction {
	
	   @Id
	   @GeneratedValue(strategy =GenerationType.IDENTITY) 
	   private Long swapId;
	   private Long userId;
	   private Long seedId;
	   
    public SwapTransaction() {    	
    }

	public SwapTransaction(Long swapId, Long userId, Long seedId) {
		super();
		this.swapId = swapId;
		this.userId = userId;
		this.seedId = seedId;
	}

	public Long getSwapId() {
		return swapId;
	}

	public void setSwapId(Long swapId) {
		this.swapId = swapId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getSeedId() {
		return seedId;
	}

	public void setSeedId(Long seedId) {
		this.seedId = seedId;
	}	
    
    
 
}
