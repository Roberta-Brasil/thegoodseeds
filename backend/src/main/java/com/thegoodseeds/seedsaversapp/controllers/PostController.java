package com.thegoodseeds.seedsaversapp.controllers;

import java.net.URI;
import java.security.Principal;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.thegoodseeds.seedsaversapp.dtos.request.CommentRequestDTO;
import com.thegoodseeds.seedsaversapp.dtos.request.PostRequestDTO;
import com.thegoodseeds.seedsaversapp.dtos.response.PostResponseDTO;

import com.thegoodseeds.seedsaversapp.services.PostService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

	@Autowired
	private PostService postService;
	


	@GetMapping
	@Operation(summary = "Find all posts in the System.")
	public ResponseEntity<List<PostResponseDTO>> findAll(@RequestParam(required=false) String seedPopularName) {

		List<PostResponseDTO> postsDto = postService.findAll(seedPopularName);

		return ResponseEntity.ok().body(postsDto);
	}

	@GetMapping(value = "/{id}")
	@Operation(summary = "Find a specific post in the System by id")
	public ResponseEntity<PostResponseDTO> findById(@PathVariable Long id) {

		PostResponseDTO postDto = postService.findById(id);

		return ResponseEntity.ok().body(postDto);
	}

	@PostMapping
	@Operation(summary = "Insert a post in the system.")
	public ResponseEntity<PostResponseDTO> insert(@RequestBody @Valid PostRequestDTO postDTO, Principal principal,
			UriComponentsBuilder uriBuilder) {

		PostResponseDTO postDto = postService.insert(postDTO, principal);

		URI uri = uriBuilder.path("/post/{id}").buildAndExpand(postDto.getId()).toUri();

		return ResponseEntity.created(uri).body(postDto);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Update post in the system.")
	public ResponseEntity<PostResponseDTO> update(@PathVariable Long id, @RequestBody PostRequestDTO postDTO,
			Principal principal) {

		PostResponseDTO postDto = postService.update(id, postDTO, principal);

		return ResponseEntity.ok().body(postDto);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Delete a post in the system.")
	public ResponseEntity<String> delete(@PathVariable Long id, Principal principal) {

		String message = postService.delete(id, principal);

		return ResponseEntity.ok().body(message);
	}

	@PutMapping("/{id}/comment")
	@Operation(summary = "Create a new comment on the post (adding a comment).")
	public ResponseEntity<PostResponseDTO> commentingPost(@PathVariable Long id,
			@RequestBody CommentRequestDTO commentDTO, Principal principal) {

		PostResponseDTO postDto = postService.commentingPost(id, commentDTO, principal);

		return ResponseEntity.ok().body(postDto);
	}
	
	@GetMapping("/{id}/likes")
	@Operation(summary = "Likes Action")
	public ResponseEntity<String> likesPostUser(@PathVariable Long id, Principal principal) {
		return ResponseEntity.ok().body(postService.likesClick(id, principal));
	}
}
