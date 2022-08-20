package com.thegoodseeds.seedsaversapp.services.businessRules.updateUser;

import org.springframework.stereotype.Component;

import com.thegoodseeds.seedsaversapp.dtos.UserDTO;
import com.thegoodseeds.seedsaversapp.entities.User;

@Component
public class NameNull implements UpdateUserValidation {

	@Override
	public void validation(User user, UserDTO userDTO) {
		if (userDTO.getName() != null) {
			user.setName(userDTO.getName());
		}

	}

}
