package com.thegoodseeds.seedsaversapp.services.businessRules.updateUser;

import com.thegoodseeds.seedsaversapp.dtos.UserDTO;
import com.thegoodseeds.seedsaversapp.entities.User;

public interface UpdateUserValidation {
	
	void validation(User user, UserDTO userDTO);

}
