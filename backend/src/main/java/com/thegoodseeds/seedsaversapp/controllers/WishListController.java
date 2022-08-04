package com.thegoodseeds.seedsaversapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thegoodseeds.seedsaversapp.entities.WishList;
import com.thegoodseeds.seedsaversapp.repositories.WishListRepository;

@RestController
@RequestMapping(value = "/wishlists")
public class WishListController {

	@Autowired
	private WishListRepository wishlistRepo;

	@GetMapping
	public ResponseEntity<List<WishList>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(wishlistRepo.findAll());
	}

}
