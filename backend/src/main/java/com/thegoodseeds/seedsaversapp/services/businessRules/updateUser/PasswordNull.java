package com.thegoodseeds.seedsaversapp.services.businessRules.updateUser;

import org.springframework.stereotype.Component;

import com.thegoodseeds.seedsaversapp.dtos.UserDTO;
import com.thegoodseeds.seedsaversapp.entities.User;

@Component
public class PasswordNull implements UpdateUserValidation {

	@Override
	public void validation(User user, UserDTO userDTO) {
		
		if (userDTO.getPassword() != null) {
			user.setPassword(userDTO.getPassword());
		}

	}

}
