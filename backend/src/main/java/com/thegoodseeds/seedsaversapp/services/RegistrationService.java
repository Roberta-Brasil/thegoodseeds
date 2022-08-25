package com.thegoodseeds.seedsaversapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.thegoodseeds.seedsaversapp.dtos.request.RegisterUserRequestDTO;
import com.thegoodseeds.seedsaversapp.entities.User;
import com.thegoodseeds.seedsaversapp.repositories.UserRepository;
import com.thegoodseeds.seedsaversapp.services.businessRules.registerUser.RegisterUserValidation;
import com.thegoodseeds.seedsaversapp.services.exceptions.EmailAlreadyExistsException;

@Service
@Profile(value = { "test", "prod", "dev02" })
public class RegistrationService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private List<RegisterUserValidation> registerUserValidations;
	
	//This method registers the user

	public User register(RegisterUserRequestDTO userDTO) {

	    registerUserValidations.forEach(v -> v.validation(userDTO, userRepo));

		User user = createUser(userDTO);

		user = userRepo.save(user);

		return user;
	}
    

	//This method creates the user by Dto data
	private User createUser(RegisterUserRequestDTO userDto) {

		String password = userDto.getPassword();

		String passwordEncoder = encoder.encode(password);

		User user = new User(userDto.getUserName(), passwordEncoder, userDto.getEmail());

		return user;
	}

}
