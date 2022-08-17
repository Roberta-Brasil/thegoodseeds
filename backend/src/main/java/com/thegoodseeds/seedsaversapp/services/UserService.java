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

import com.thegoodseeds.seedsaversapp.dtos.response.SeedResponseDto;
import com.thegoodseeds.seedsaversapp.dtos.response.UserResponseDto;
import com.thegoodseeds.seedsaversapp.entities.Seed;
import com.thegoodseeds.seedsaversapp.entities.User;
import com.thegoodseeds.seedsaversapp.repositories.CommentRepository;
import com.thegoodseeds.seedsaversapp.repositories.PostRepository;
import com.thegoodseeds.seedsaversapp.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private PostRepository postRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private CommentRepository commentRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { // Método que mostra pro
																								// spring security como
																								// será feita a
																							// autenticação.
		Optional<User> user = userRepo.findByEmail(username);
		return user.get();
	}

	//This method returns all seeds added by user
	public List<SeedResponseDto> findAllSeedsByUser(Principal userPrincipal) {
		
		String email = userPrincipal.getName();
		
		User user = returnUser(email);
		
		List<Seed> seeds = user.getSeeds();
		
		List<SeedResponseDto> seedsDto = seeds.stream().map(SeedResponseDto::new).collect(Collectors.toList());
		
		return seedsDto;
	}

	public UserResponseDto myProfile(Principal userPrincipal) {
		
		String email = userPrincipal.getName();
		
		User user = returnUser(email);
		
		return new UserResponseDto(user);
	}
	
	
 private User returnUser(String email) {
       return userRepo.findByEmail(email).get();
}
	

	
}
