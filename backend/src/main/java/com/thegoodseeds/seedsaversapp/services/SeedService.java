package com.thegoodseeds.seedsaversapp.services;

import java.security.Principal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.thegoodseeds.seedsaversapp.dtos.request.SeedRequestDto;
import com.thegoodseeds.seedsaversapp.dtos.response.SeedResponseDto;
import com.thegoodseeds.seedsaversapp.entities.Seed;
import com.thegoodseeds.seedsaversapp.entities.User;
import com.thegoodseeds.seedsaversapp.enums.TypeOfStorage;
import com.thegoodseeds.seedsaversapp.repositories.SeedRepository;
import com.thegoodseeds.seedsaversapp.repositories.UserRepository;
import com.thegoodseeds.seedsaversapp.services.exceptions.PostOwnerException;
import com.thegoodseeds.seedsaversapp.services.exceptions.ResourceNotFoundException;

@Service
public class SeedService {
	
	@Autowired
	private SeedRepository seedRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	
	public SeedResponseDto insert(SeedRequestDto obj, Principal userPrincipal) {
		
		String email = userPrincipal.getName();
		
		User user = returnUser(email);
		
		Seed seed = new Seed();
		
		setAttributes(seed,obj);
		
		seed.setUser(user);
		
		seedRepo.save(seed);
		
		seed = seedRepo.save(seed);
		
		 user.addSeed(seed);
  
		userRepo.save(user);
				
		
		return new SeedResponseDto(seed);	
	}
	
	public SeedResponseDto update(SeedRequestDto obj, Long id,Principal principal) {
		
		Seed seed = returnSeed(id);
		
		 permissionValidation(principal.getName(), seed.getUser().getEmail(),
				 "This post does not belong to you, just the post owner can update this post.");
		
		 updateAttributes(seed,obj);
		
		seed = seedRepo.save(seed);
		 
		return new SeedResponseDto(seed);
	}

	public String delete(Long id,Principal user) {
		
		Seed seed = returnSeed(id);
		
		String popularName = seed.getPopularName();
		
		String ownerEmail = seed.getUser().getEmail();
		
		 permissionValidation(user.getName(), ownerEmail, 
				 "This post does not belong to you, just the post owner can delete this post.");
		 
		 
			seedRepo.deleteById(id);
		
		
		return "Seed "+popularName+"was deleted successfully";
	}
	
	private Seed returnSeed(Long id) {
	try {
	
		return seedRepo.findById(id).get();
		
	} catch (EmptyResultDataAccessException e) {
		throw new ResourceNotFoundException("There is no post with id: " + id);
	}
		
	}
	
	private void updateAttributes(Seed seed, SeedRequestDto obj) {
		
		if(obj.getPopularName()!=null) {
		seed.setPopularName(obj.getPopularName());
		}
		
		if(obj.getTypeOfStorage() !=null) {
		seed.setTypeOfStorage(TypeOfStorage.valueOf(obj.getTypeOfStorage()));
		}
		
		if(obj.getSeedImg()!=null) {
		seed.setSeedImg(obj.getSeedImg());
		}
		
		if(obj.getSeedDescription()!=null) {
		seed.setSeedDescription(obj.getSeedDescription());
		}
		
		if(obj.getScientificName()!=null) {
		seed.setScientificName(obj.getScientificName());
		}
		
		if(obj.getFamilyName()!=null) {
		seed.setFamilyName(obj.getFamilyName());
		}
		
	}
	
	private void setAttributes(Seed seed, SeedRequestDto obj) {
		
		seed.setPopularName(obj.getPopularName());
		seed.setTypeOfStorage(TypeOfStorage.valueOf(obj.getTypeOfStorage()));
		seed.setSeedImg(obj.getSeedImg());
		seed.setSeedDescription(obj.getSeedDescription());
		seed.setScientificName(obj.getScientificName());
		seed.setFamilyName(obj.getFamilyName());
		seed.setLocationOfCollection(obj.getLocationOfCollection());
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		seed.setDateOfCollection(LocalDate.parse(obj.getDateOfCollection(),dtf));
	}
	

	
	private User returnUser(String email) {
		
		Optional<User> user = userRepo.findByEmail(email);
		
		return user.get();
	}

	private void permissionValidation(String emailUserLogged, String ownerEmail, String msg) {

		if (!emailUserLogged.equals(ownerEmail)) {
			throw new PostOwnerException(msg);
		}

	}
	

}
