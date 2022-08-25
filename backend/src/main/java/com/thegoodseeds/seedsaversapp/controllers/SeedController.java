package com.thegoodseeds.seedsaversapp.controllers;

import java.net.URI;
import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.thegoodseeds.seedsaversapp.dtos.request.SeedRequestDTO;
import com.thegoodseeds.seedsaversapp.dtos.response.SeedResponseDTO;
import com.thegoodseeds.seedsaversapp.services.SeedService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/seeds")
public class SeedController {

	@Autowired
	private SeedService seedService;

	@PostMapping
	@Operation(summary = "Insert seed in the System.")
	public ResponseEntity<SeedResponseDTO> insert(@RequestBody @Valid SeedRequestDTO seedDTO,
			UriComponentsBuilder uriBuilder, Principal principal) {

		SeedResponseDTO seedDto = seedService.insert(seedDTO, principal);

		URI uri = uriBuilder.path("/seed/{id}").buildAndExpand(seedDto.getId()).toUri();

		return ResponseEntity.created(uri).body(seedDto);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Update seed in the System.")
	public ResponseEntity<SeedResponseDTO> update(@RequestBody SeedRequestDTO seedDTO, @PathVariable Long id,
			Principal principal) {

		SeedResponseDTO dto = seedService.update(seedDTO, id, principal);

		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Delete seed in the System.")
	public ResponseEntity<String> delete(@PathVariable Long id, Principal principal) {

		String msg = seedService.delete(id, principal);

		return ResponseEntity.ok().body(msg);
	}

}
