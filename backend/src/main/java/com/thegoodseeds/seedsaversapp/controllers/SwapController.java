package com.thegoodseeds.seedsaversapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thegoodseeds.seedsaversapp.entities.Swap;
import com.thegoodseeds.seedsaversapp.repositories.SwapRepository;

@RestController
@RequestMapping(value = "/swaps")
public class SwapController {

	@Autowired
	private SwapRepository swapRepo;

	@GetMapping
	public ResponseEntity<List<Swap>> findAll() {
		
		
		return ResponseEntity.status(HttpStatus.OK).body(swapRepo.findAll());
	}

}
