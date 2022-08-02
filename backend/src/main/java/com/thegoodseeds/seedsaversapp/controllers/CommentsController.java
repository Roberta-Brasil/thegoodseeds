package com.thegoodseeds.seedsaversapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thegoodseeds.seedsaversapp.entities.Comments;
import com.thegoodseeds.seedsaversapp.repositories.CommentsRepository;

@RestController
@RequestMapping(value = "/comments")
public class CommentsController {

	@Autowired
	CommentsRepository commentsRepo;

	@GetMapping
	public ResponseEntity<List<Comments>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(commentsRepo.findAll());
	}

}
