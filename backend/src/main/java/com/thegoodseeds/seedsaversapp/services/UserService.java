package com.thegoodseeds.seedsaversapp.services;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.thegoodseeds.seedsaversapp.dtos.UserDTO;
import com.thegoodseeds.seedsaversapp.dtos.response.SeedResponseDTO;
import com.thegoodseeds.seedsaversapp.entities.Seed;
import com.thegoodseeds.seedsaversapp.entities.User;
import com.thegoodseeds.seedsaversapp.repositories.SeedRepository;
import com.thegoodseeds.seedsaversapp.repositories.UserRepository;
import com.thegoodseeds.seedsaversapp.services.businessRules.updateUser.UpdateUserValidation;
import com.thegoodseeds.seedsaversapp.services.exceptions.ResourceNotFoundException;

// This class implements the user's methods for each system function.

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private SeedRepository seedRepo;

	@Autowired
	private List<UpdateUserValidation> validations;

	// This methods shows the spring security how the authentication will be made
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = returnUser(username);
		
		return user;
	}

	// This method returns the profile info of the logged user
	public UserDTO myProfile(Principal principal) {

		String email = principal.getName();

		User user = returnUser(email);

		return new UserDTO(user);
	}

	// This method returns all seeds added by user
	public List<SeedResponseDTO> findAllSeedsByUser(Principal principal) {

		User user = returnUser(principal.getName());
		Set<Seed> seeds = new HashSet<>();
		for (Seed obj : user.getSeeds()) {
			seeds.add(obj);
		}

		List<SeedResponseDTO> seedsDTO = seeds.stream().map(SeedResponseDTO::new).collect(Collectors.toList());
		
		return seedsDTO;
	}

	// This method returns the seeds by id to the logged user
	public SeedResponseDTO findSeedByIdByUser(Principal principal, Long id) {

		User user = returnUser(principal.getName());
			
		Seed seed = returnSeed(user,id);

		return new SeedResponseDTO(seed);
	}

	// this method update the user profile

	public UserDTO update(Principal principal, UserDTO userDTO) {

		User user = returnUser(principal.getName());

		setAttributes(user, userDTO);

		user = userRepo.save(user);

		return new UserDTO(user);
	}

	// this method returns user by email
	private User returnUser(String email) {
		return userRepo.findByEmail(email).get();
	}
	
	//This method returns the seed by id  user
	private Seed returnSeed(User user, Long id) { 
		
		Optional<Seed> seed = seedRepo.findById(id);
		
		if (seed == null) {

//		if( seed.isEmpty() ||!seed.get().getUser().equals(user)) {
			throw new ResourceNotFoundException(
					"Seed id : " + id + " was not found or this seed does not belong to this user");
		}
//		Seed result= null;
//		if(seed.isPresent()) {
//			result = seed.get();
//		};
		return seed.get();
	} 

	// this method set the user profile information
	private void setAttributes(User user, UserDTO userDTO) {

		validations.forEach(v -> v.validation(user, userDTO));

		user.setChangeDate();

	}

}
