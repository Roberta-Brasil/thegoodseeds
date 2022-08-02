package com.thegoodseeds.seedsaversapp.enums;

public enum TypeOfStorage {
	
	BAG_STORAGE(1), //I relate each type of storage to each number to avoid break the application. 
	BULK_OPEN(2),
    MOIST_STORAGE(3),
    DRY_STORAGE(4),
    DRY_STORAGE_MOISTURE(5),
    DRY_STORAGE_MOISTURE_TEMPERATURE(6),
    CRYOPRESERVATION(7);
    
	private int codeType;
	
	private TypeOfStorage(int codeType) {
		this.codeType =codeType;
	}

	public int getCodeType() {
		return codeType;
	}

	public void setCodeType(int codeType) {
		this.codeType = codeType;
	}
	
	//conversion of the numeric value to enumerated.
	// I declare it static to access it from other class.
	public static TypeOfStorage valueOf(int codeType) {
		
		//this for loop transverse the order status until it gets the correspondent Type Of Storage status and return the value.
		for(TypeOfStorage value : TypeOfStorage.values()) {
			if(codeType == value.getCodeType()) {
				return value;
			}
		} // I used this exception when the code receive a invalid seed status.
		throw new IllegalArgumentException("Invalid TypeOfStorage code");
	}

}

