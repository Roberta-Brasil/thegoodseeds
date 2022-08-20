package com.thegoodseeds.seedsaversapp.services;

import java.security.Principal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thegoodseeds.seedsaversapp.dtos.request.SeedRequestDTO;
import com.thegoodseeds.seedsaversapp.dtos.response.SeedResponseDTO;
import com.thegoodseeds.seedsaversapp.entities.Seed;
import com.thegoodseeds.seedsaversapp.entities.User;
import com.thegoodseeds.seedsaversapp.enums.TypeOfStorage;
import com.thegoodseeds.seedsaversapp.repositories.SeedRepository;
import com.thegoodseeds.seedsaversapp.repositories.UserRepository;
import com.thegoodseeds.seedsaversapp.services.businessRules.updateSeed.UpdateSeedValidation;
import com.thegoodseeds.seedsaversapp.services.exceptions.DateNotAllowedException;
import com.thegoodseeds.seedsaversapp.services.exceptions.PostOwnerException;
import com.thegoodseeds.seedsaversapp.services.exceptions.ResourceNotFoundException;

@Service
public class SeedService {

	@Autowired
	private SeedRepository seedRepo;

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private List<UpdateSeedValidation> validations;

	// This method allows the user to add a seed

	public SeedResponseDTO insert(SeedRequestDTO seedDTO, Principal principal) {

		verifyDate(seedDTO.getDateOfCollection());

		String email = principal.getName();

		User user = returnUser(email);

		Seed seed = new Seed();

		setAttributes(seed, seedDTO);

		seed.setUser(user);

		seedRepo.save(seed);

		seed = seedRepo.save(seed);

		user.addSeed(seed);

		userRepo.save(user);

		return new SeedResponseDTO(seed);
	}

	// This method allows the user to update the post the seed information
	public SeedResponseDTO update(SeedRequestDTO seedDTO, Long id, Principal principal) {

		verifyDate(seedDTO.getDateOfCollection());

		Seed seed = returnSeed(id);

		permissionValidation(principal.getName(), seed.getUser().getEmail(),
				"This post does not belong to you, just the post owner can update this post.");

		updateAttributes(seed, seedDTO);

		seed = seedRepo.save(seed);

		return new SeedResponseDTO(seed);
	}

	// This method allows the user to delete a seed
	public String delete(Long id, Principal principal) {

		Seed seed = returnSeed(id);

		String popularName = seed.getPopularName();

		String ownerEmail = seed.getUser().getEmail();

		permissionValidation(principal.getName(), ownerEmail,
				"This post does not belong to you, just the post owner can delete this post.");

		seedRepo.deleteById(id);

		return "Seed " + popularName + "was deleted successfully";
	}

	// This method allows the user to return the seed by id
	private Seed returnSeed(Long id) {
		return seedRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("There is no seed with id: " + id));
	}

	// This method allows the user to update the seed attributes
	private void updateAttributes(Seed seed, SeedRequestDTO seedDTO) {

		validations.forEach(v-> v.validation(seed, seedDTO));


	}
	// This method create a seed entity and set the attributes from DTO to Seed.
	private void setAttributes(Seed seed, SeedRequestDTO seedDTO) {

		seed.setPopularName(seedDTO.getPopularName());
		seed.setTypeOfStorage(TypeOfStorage.valueOf(seedDTO.getTypeOfStorage()));
		seed.setSeedImg(seedDTO.getSeedImg());
		seed.setSeedDescription(seedDTO.getSeedDescription());
		seed.setScientificName(seedDTO.getScientificName());
		seed.setFamilyName(seedDTO.getFamilyName());
		seed.setLocationOfCollection(seedDTO.getLocationOfCollection());

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		seed.setDateOfCollection(LocalDate.parse(seedDTO.getDateOfCollection(), dtf));
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

	private void verifyDate(String dateOfCollection) {

		LocalDate localDate = returnLocalDate(dateOfCollection);

		if (localDate.isAfter(LocalDate.now())) {
			throw new DateNotAllowedException("You cannot enter a date of collection after today's date");
		}

	}

	private LocalDate returnLocalDate(String date) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		LocalDate localDate = LocalDate.parse(date, dtf);

		return localDate;
	}

}
