package com.thegoodseeds.seedsaversapp.services;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.thegoodseeds.seedsaversapp.dtos.UserDto;
import com.thegoodseeds.seedsaversapp.dtos.response.SeedResponseDto;
import com.thegoodseeds.seedsaversapp.entities.Seed;
import com.thegoodseeds.seedsaversapp.entities.User;
import com.thegoodseeds.seedsaversapp.repositories.UserRepository;
import com.thegoodseeds.seedsaversapp.services.exceptions.ResourceNotFoundException;

@Service
public class UserService implements UserDetailsService {

//	@Autowired
//	private PostRepository postRepo;

	@Autowired
	private UserRepository userRepo;

//	@Autowired
//	private CommentRepository commentRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { // Método que mostra pro
																								// spring security como
																								// será feita a
																								// autenticação.
		Optional<User> user = userRepo.findByEmail(username);
		return user.get();
	}

	// This method returns all seeds added by user
	public List<SeedResponseDto> findAllSeedsByUser(Principal userPrincipal) {

		String email = userPrincipal.getName();

		User user = returnUser(email);

		List<Seed> seeds = user.getSeeds();

		List<SeedResponseDto> seedsDto = seeds.stream().map(SeedResponseDto::new).collect(Collectors.toList());

		return seedsDto;
	}

	public UserDto myProfile(Principal userPrincipal) {

		String email = userPrincipal.getName();

		User user = returnUser(email);

		return new UserDto(user);
	}

	public SeedResponseDto findSeedByIdByUser(Principal principal, Long id) {

		User user = returnUser(principal.getName());

		Seed seedVar = null;

		for (Seed seed : user.getSeeds()) {

			if (seed.getSeedId() == id) {
				seedVar = seed;
			}
		}

		if (seedVar == null) {
			throw new ResourceNotFoundException(
					"Seed id : " + id + " wasn't found or this seed doesn't belong to this user");
		}

		return new SeedResponseDto(seedVar);
	}

	public UserDto update(UserDto userDto, Principal principal) {

		User user = returnUser(principal.getName());

		setAttributes(user, userDto);

		user = userRepo.save(user);

		return new UserDto(user);
	}

	private void setAttributes(User user, UserDto userDto) {

		if (userDto.getProfileImg() != null) {
			user.setProfileImg(userDto.getProfileImg());
		}

		if (userDto.getPhoneNumber() != null) {
			user.setPhoneNumber(userDto.getPhoneNumber());
		}

		if (userDto.getEmail() != null) {
			user.setEmail(userDto.getEmail());
		}

		if (userDto.getName() != null) {
			user.setName(userDto.getName());
		}

		if (userDto.getPassword() != null) {
			user.setPassword(userDto.getPassword());
		}

		if (userDto.getFullName() != null) {
			user.setFullName(userDto.getFullName());
		}

		user.setChangeDate();

	}

	private User returnUser(String email) {
		return userRepo.findByEmail(email).get();
	}

}
