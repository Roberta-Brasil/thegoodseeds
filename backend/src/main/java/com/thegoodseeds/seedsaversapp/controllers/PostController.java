package com.thegoodseeds.seedsaversapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thegoodseeds.seedsaversapp.entities.Post;
import com.thegoodseeds.seedsaversapp.entities.dtos.PostRequestDTO;
import com.thegoodseeds.seedsaversapp.repositories.PostRepository;

@RestController
@RequestMapping(value= "/post")
public class PostController {
	
	@Autowired
	PostRepository postRepo;
	
	@GetMapping
	public ResponseEntity<List<Post>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(postRepo.findAll());
	}

	@PostMapping
	public ResponseEntity<Post> insert(@RequestBody PostRequestDTO obj) {
		Post result = postRepo.save(new Post(obj.getLikesQuantity(), obj.getTitle(), obj.getPostMessage()));
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}
}
