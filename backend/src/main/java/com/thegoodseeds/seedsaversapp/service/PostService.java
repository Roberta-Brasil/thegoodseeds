package com.thegoodseeds.seedsaversapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.thegoodseeds.seedsaversapp.dtos.request.CommentRequestDto;
import com.thegoodseeds.seedsaversapp.dtos.request.PostRequestDto;
import com.thegoodseeds.seedsaversapp.dtos.response.PostResponseDto;
import com.thegoodseeds.seedsaversapp.entities.Comment;
import com.thegoodseeds.seedsaversapp.entities.Post;
import com.thegoodseeds.seedsaversapp.entities.User;
import com.thegoodseeds.seedsaversapp.repositories.CommentRepository;
import com.thegoodseeds.seedsaversapp.repositories.PostRepository;
import com.thegoodseeds.seedsaversapp.repositories.UserRepository;
import com.thegoodseeds.seedsaversapp.service.exceptions.ResourceNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private CommentRepository commentRepo;
	
	public List<PostResponseDto> findAll() {
		
		List<Post> posts = postRepo.findAll(); 
		
		List<PostResponseDto> postsDto = posts.stream().map(PostResponseDto::new).collect(Collectors.toList());
		
		return postsDto;
	}
	
	public PostResponseDto findById(Long id) {
		
		Post post = returnPostDataBase(id);
		
		return new PostResponseDto(post);
	}
	
	public PostResponseDto insert(PostRequestDto obj) {
		
		Post post = new Post();
		
		setAttributes(post,obj);
		
		User user = userRepo.findById(1L).get();
		
		post.setUser(user);
		
		post = postRepo.save(post);

		
		user.addPost(post);
		
		userRepo.save(user);
		
		return new PostResponseDto(post);
		
	}

	
	public PostResponseDto update(Long id, PostRequestDto obj) {
		
		Post post = returnPostDataBase(id);
		
		setAttributes(post,obj);
		
		post = postRepo.save(post);
		
		return new PostResponseDto(post);
	}
	
	public String delete(Long id) {
		
		try {
		postRepo.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("There is no post with id: "+id);
		}
			
		return "Post: "+id+" deleted!";
	}
	
	public PostResponseDto commentingPost(Long id, CommentRequestDto obj) {
		
	
		Post post = returnPostDataBase(id);
		
		Comment comment = new Comment();
		
		comment.setCommentMessage(obj.getMessage());
		comment.setPost(post);
		
	
		User user = new User();
		user.setUsername("João");
		user.setProfileImg("fotinha.com.br");
		
		userRepo.save(user);
		
			
		comment.setUser(user);
		
		
		commentRepo.save(comment);
		
		post.addComment(comment);
		user.getComments().add(comment);
		
		userRepo.save(user);
		
		
		post = postRepo.save(post);
		
		return new PostResponseDto(post);
	}
	
	private void setAttributes (Post post, PostRequestDto obj) {
		post.setTitle(obj.getTitle());
		post.setPostMessage(obj.getPostMessage());
	}
	
	
	private Post returnPostDataBase(Long id) {
		Post post = postRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("There is no post with id : "+id));
		return post;
	}
	
}
