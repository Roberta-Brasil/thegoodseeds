package com.thegoodseeds.seedsaversapp.services.businessRules.registerUser;

import com.thegoodseeds.seedsaversapp.dtos.request.RegisterUserRequestDTO;
import com.thegoodseeds.seedsaversapp.repositories.UserRepository;

public interface RegisterUserValidation {

	void validation(RegisterUserRequestDTO userDto , UserRepository userRepo);
}
