package com.thegoodseeds.seedsaversapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thegoodseeds.seedsaversapp.entities.Comment;
import com.thegoodseeds.seedsaversapp.repositories.CommentRepository;

@RestController
@RequestMapping(value = "/comments")
public class CommentController {

	@Autowired
	CommentRepository commentsRepo;

	@GetMapping
	public ResponseEntity<List<Comment>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(commentsRepo.findAll());
	}

}
