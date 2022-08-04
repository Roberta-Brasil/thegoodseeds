package com.thegoodseeds.seedsaversapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thegoodseeds.seedsaversapp.entities.SwapTransaction;
import com.thegoodseeds.seedsaversapp.repositories.SwapTransactionRepository;

@RestController
@RequestMapping(value = "/swaptransactions")
public class SwapTransactionController {

	@Autowired
	private SwapTransactionRepository swapTransactionRepo;

	@GetMapping
	public ResponseEntity<List<SwapTransaction>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(swapTransactionRepo.findAll());
	}

}
