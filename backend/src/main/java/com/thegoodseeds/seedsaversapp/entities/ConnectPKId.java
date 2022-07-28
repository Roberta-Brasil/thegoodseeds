package com.thegoodseeds.seedsaversapp.entities;

import java.io.Serializable;
import java.util.Objects;



@SuppressWarnings("serial")
public class ConnectPKId implements Serializable {
	
	 private Long userId;
	 private Long followedId;
	 
	@Override
	public int hashCode() {
		return Objects.hash(followedId, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConnectPKId other = (ConnectPKId) obj;
		return Objects.equals(followedId, other.followedId) && Objects.equals(userId, other.userId);
	}
	 
	 

}
