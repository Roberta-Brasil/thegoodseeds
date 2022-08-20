package com.thegoodseeds.seedsaversapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.thegoodseeds.seedsaversapp.dtos.request.RegisterUserRequestDTO;
import com.thegoodseeds.seedsaversapp.entities.User;
import com.thegoodseeds.seedsaversapp.repositories.UserRepository;
import com.thegoodseeds.seedsaversapp.services.exceptions.EmailAlreadyExistsException;

@Service
@Profile(value = { "test", "prod" })
public class RegistrationService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PasswordEncoder encoder;

	public User register(RegisterUserRequestDTO userDto) {

		String email = userDto.getEmail();

		emailAlreadyExistsValidation(email);

		User user = createUser(userDto);

		user = userRepo.save(user);

		return user;
	}

	private void emailAlreadyExistsValidation(String email) {

		Optional<User> userDataBase = userRepo.findByEmail(email);

		if (userDataBase.isPresent()) {
			throw new EmailAlreadyExistsException("Email " + email + " already exists in the system");
		}
	}

	private User createUser(RegisterUserRequestDTO userDto) {

		String password = userDto.getPassword();

		String passwordEncoder = encoder.encode(password);

		User user = new User(userDto.getUserName(), passwordEncoder, userDto.getEmail());

		return user;
	}

}
