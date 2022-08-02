package com.thegoodseeds.seedsaversapp.enums;

public enum SeedStatus {
	
	ACTIVATED(1), //I relate each status to each number to avoid break the application. 
	DEACTIVATED(2);
	
	private int code;
	
	private SeedStatus(int code) {
		this.code =code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	//conversion of the numeric value to enumerated.
	// I declare it static to access it from other class.
	public static SeedStatus valueOf(int code) {
		
		//this for loop transverse the order status until it gets the correspondent seed status and return the value.
		for(SeedStatus value : SeedStatus.values()) {
			if(code == value.getCode()) {
				return value;
			}
		} // I used this exception when the code receive a invalid seed status.
		throw new IllegalArgumentException("Invalid SeedStatus code");
	}

}
