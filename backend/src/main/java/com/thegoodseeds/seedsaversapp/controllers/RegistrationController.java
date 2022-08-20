package com.thegoodseeds.seedsaversapp.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.thegoodseeds.seedsaversapp.dtos.request.RegisterUserRequestDTO;
import com.thegoodseeds.seedsaversapp.entities.User;
import com.thegoodseeds.seedsaversapp.services.RegistrationService;

import io.swagger.v3.oas.annotations.Operation;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/registration")
@Profile(value = {"test","prod"})
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	
	@PostMapping
	@Operation(summary = "Register an user in the System")
	public ResponseEntity<String> register(@RequestBody RegisterUserRequestDTO userDto,UriComponentsBuilder uriBuilder) {
		
		User user  = registrationService.register(userDto);
		
		URI uri = uriBuilder.path("/registration/{id}").buildAndExpand(user.getUserId()).toUri();
		
		String msg = user.getName()+", your account was registered successfully";
		
		return ResponseEntity.created(uri).body(msg);
	}

}
