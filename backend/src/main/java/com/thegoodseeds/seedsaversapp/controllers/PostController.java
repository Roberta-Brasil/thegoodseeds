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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.thegoodseeds.seedsaversapp.dtos.request.CommentRequestDto;
import com.thegoodseeds.seedsaversapp.dtos.request.PostRequestDto;
import com.thegoodseeds.seedsaversapp.dtos.response.PostResponseDto;
import com.thegoodseeds.seedsaversapp.services.PostService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/post")
public class PostController {

	@Autowired
	private PostService postService;

	@GetMapping
	@Operation(summary = "Find all posts in the System.")
	public ResponseEntity<List<PostResponseDto>> findAll() {

		List<PostResponseDto> postsDto = postService.findAll();

		return ResponseEntity.ok().body(postsDto);
	}

	@GetMapping(value = "/{id}")
	@Operation(summary = "Find a specific post in the System by id")
	public ResponseEntity<PostResponseDto> findById(@PathVariable Long id) {

		PostResponseDto postDto = postService.findById(id);

		return ResponseEntity.ok().body(postDto);
	}

	@PostMapping
	@Operation(summary = "Insert a post in the system.")
	public ResponseEntity<PostResponseDto> insert(@RequestBody @Valid PostRequestDto obj, Principal principal,
			UriComponentsBuilder uriBuilder) {

		PostResponseDto postDto = postService.insert(obj, principal);

		URI uri = uriBuilder.path("/post/{id}").buildAndExpand(postDto.getId()).toUri();

		return ResponseEntity.created(uri).body(postDto);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Update post in the system.")
	public ResponseEntity<PostResponseDto> update(@PathVariable Long id, @RequestBody PostRequestDto obj,
			Principal user) {

		PostResponseDto postDto = postService.update(id, obj, user);

		return ResponseEntity.ok().body(postDto);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Delete a post in the system.")
	public ResponseEntity<String> delete(@PathVariable Long id, Principal user) {

		String message = postService.delete(id, user);

		return ResponseEntity.ok().body(message);
	}

	@PutMapping("/{id}/comment")
	@Operation(summary = "Create a new comment on the post (adding a comment).")
	public ResponseEntity<PostResponseDto> commentingPost(@PathVariable Long id, @RequestBody CommentRequestDto obj,
			Principal principal) {

		PostResponseDto postDto = postService.commentingPost(id, obj, principal);

		return ResponseEntity.ok().body(postDto);
	}

}
