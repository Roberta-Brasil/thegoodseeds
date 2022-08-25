package com.thegoodseeds.seedsaversapp.services.businessRules.registerUser;

import java.util.Optional;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.thegoodseeds.seedsaversapp.dtos.request.RegisterUserRequestDTO;
import com.thegoodseeds.seedsaversapp.entities.User;
import com.thegoodseeds.seedsaversapp.repositories.UserRepository;
import com.thegoodseeds.seedsaversapp.services.exceptions.EmailAlreadyExistsException;

@Component
@Order(1)
public class EmailAlreadyRegistered implements RegisterUserValidation {

	//This method displays an alert that the email already exists in the database
	
	@Override
	public void validation(RegisterUserRequestDTO userDto, UserRepository userRepo) {
		
		    String email = userDto.getEmail();

			Optional<User> userDataBase = userRepo.findByEmail(email);

			if (userDataBase.isPresent()) {
				throw new EmailAlreadyExistsException("Email " + email + " already exists in the system");
			}
		}
		
	}


