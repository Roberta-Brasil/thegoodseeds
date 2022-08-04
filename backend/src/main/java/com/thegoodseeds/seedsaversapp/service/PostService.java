package com.thegoodseeds.seedsaversapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thegoodseeds.seedsaversapp.dtos.request.PostRequestDTO;
import com.thegoodseeds.seedsaversapp.dtos.response.PostResponseDto;
import com.thegoodseeds.seedsaversapp.entities.Post;
import com.thegoodseeds.seedsaversapp.entities.User;
import com.thegoodseeds.seedsaversapp.repositories.PostRepository;
import com.thegoodseeds.seedsaversapp.repositories.UserRepository;
import com.thegoodseeds.seedsaversapp.service.exceptions.ResourceNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	public List<PostResponseDto> findAll() {
		List<Post> posts = postRepo.findAll(); 
		List<PostResponseDto> postsDto = posts.stream().map(PostResponseDto::new).collect(Collectors.toList());
		return postsDto;
	}
	
	public PostResponseDto findById(Long id) {
		
		Post post = postRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("There is no post with id : "+id));
		
		return new PostResponseDto(post);
	}
	
	public PostResponseDto insert(PostRequestDTO obj) {
		
		Post post = new Post();
		post.setTitle(obj.getTitle());
		post.setPostMessage(obj.getPostMessage());
		
		User user = userRepo.findById(1L).get();
		
		post.setUser(user);
		
		post = postRepo.save(post);

		
		user.addPost(post);
		
		userRepo.save(user);
		

		return new PostResponseDto(post);
		
	}

	
}
