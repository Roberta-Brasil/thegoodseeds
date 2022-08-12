package com.thegoodseeds.seedsaversapp.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.thegoodseeds.seedsaversapp.dtos.request.SeedRequestDto;
import com.thegoodseeds.seedsaversapp.dtos.response.SeedResponseDto;
import com.thegoodseeds.seedsaversapp.services.SeedService;


@RestController
@RequestMapping(value = "/seed")
public class SeedController {

	@Autowired
	private SeedService seedService;
	

	@GetMapping
	public ResponseEntity<List<SeedResponseDto>> findAll() { 
		
		List<SeedResponseDto> seedsDto = seedService.findAll();
		
		return ResponseEntity.ok().body(seedsDto);
	}
	
	@PostMapping
	public ResponseEntity<SeedResponseDto> insert(@RequestBody SeedRequestDto obj , UriComponentsBuilder uriBuilder ) {
		
		SeedResponseDto seedDto = seedService.insert(obj);
		
		
		URI uri = uriBuilder.path("/seed/{id}").buildAndExpand(seedDto.getId()).toUri();
		
		
		return ResponseEntity.created(uri).body(seedDto);
	}
	

}
