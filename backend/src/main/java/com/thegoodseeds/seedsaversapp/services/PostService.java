package com.thegoodseeds.seedsaversapp.services;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.thegoodseeds.seedsaversapp.dtos.request.CommentRequestDTO;
import com.thegoodseeds.seedsaversapp.dtos.request.PostRequestDTO;
import com.thegoodseeds.seedsaversapp.dtos.response.PostResponseDTO;
import com.thegoodseeds.seedsaversapp.entities.Comment;
import com.thegoodseeds.seedsaversapp.entities.Post;
import com.thegoodseeds.seedsaversapp.entities.Seed;
import com.thegoodseeds.seedsaversapp.entities.User;
import com.thegoodseeds.seedsaversapp.repositories.CommentRepository;
import com.thegoodseeds.seedsaversapp.repositories.PostRepository;
import com.thegoodseeds.seedsaversapp.repositories.SeedRepository;
import com.thegoodseeds.seedsaversapp.repositories.UserRepository;
import com.thegoodseeds.seedsaversapp.services.exceptions.PostOwnerException;
import com.thegoodseeds.seedsaversapp.services.exceptions.ResourceNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private CommentRepository commentRepo;

	@Autowired
	private SeedRepository seedRepo;

	public List<PostResponseDTO> findAll(String seedPopularName) {

		    List<Post> posts = checkFilterParam(seedPopularName);
						
			List<PostResponseDTO> postsDTO = posts.stream().map(PostResponseDTO::new).collect(Collectors.toList());
			
			return postsDTO;
		}
	
	
	public PostResponseDTO findById(Long id) {

		Post post = returnPostDataBase(id);

		return new PostResponseDTO(post);
	}
	
	//This method allows the user to add a post
	public PostResponseDTO insert(PostRequestDTO postDTO, Principal principal) {

		Post post = new Post();
		setAttributes(post, postDTO);
		User user = returnUser(principal.getName());
		post.setUser(user);

		post = postRepo.save(post);

		Seed seed = seedRepo.findById(postDTO.getSeedIdDto().getId()).get();

		seed.setPost(post);
		seed = seedRepo.save(seed);

		post.setSeed(seed);
		post = postRepo.save(post);

		user.addPost(post);
		userRepo.save(user);

		return new PostResponseDTO(post);

	}
	//This method allows the user to update a post
	public PostResponseDTO update(Long id, PostRequestDTO postDto, Principal principal) {

		Post post = returnPostDataBase(id);

		String emailUserLogged = principal.getName(); // esse getName retorna o email do Usuário logado.

		String ownerEmail = post.getUser().getUsername();

		String err = "This post does not belong to you, just the post owner can update this post. ";

		permissionValidation(emailUserLogged, ownerEmail, err);

		setAttributes(post, postDto);

		post = postRepo.save(post);

		return new PostResponseDTO(post);
	}
	//This method allows the user to delete a post
	public String delete(Long id, Principal  principal) {

		Post post = returnPostDataBase(id);

		String emailUserLogged = principal.getName(); // This getName returns email from logged user.

		String ownerEmail = post.getUser().getUsername();

		String err = "This post does not belong to you, just the post owner can delete this post. ";

		permissionValidation(emailUserLogged, ownerEmail, err);

		try {
			postRepo.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("There is no post with id: " + id);
		}

		return "Post: " + id + " deleted!";
	}
	//This method allows the user to comment a post
	public PostResponseDTO commentingPost(Long id, CommentRequestDTO commentDTO, Principal principal) {

		Post post = returnPostDataBase(id);

		Comment comment = new Comment();
		

		comment.setCommentMessage(commentDTO.getMessage());
		comment.setPost(post);

		User user = returnUser(principal.getName());

		userRepo.save(user);

		comment.setUser(user);

		commentRepo.save(comment);

		post.addComment(comment);
		user.getComments().add(comment);

		userRepo.save(user);

		post = postRepo.save(post);

		return new PostResponseDTO(post);
	}
	
	 private List<Post> checkFilterParam(String seedPopularName) {
	    	
	    	List<Post> posts;
				
			if(seedPopularName == null) {
				posts = returnAllPosts();
				
			} else {
				
				posts = returnPostFilterByPopularName(seedPopularName);
				
			}
			
			return posts;
	    	
	    }
	    
		
		private List<Post> returnAllPosts() {
			return postRepo.findAll();
		}
		
		private List<Post> returnPostFilterByPopularName(String seedPopularName) {
			
		List<Seed> seeds = seedRepo.findByPopularNameContains(seedPopularName);
			
         List<Post> posts = new ArrayList<>();
			
			for(Seed seed : seeds) {
				Post post = seed.getPost();
				if(post!=null) {
					posts.add(post);
				}
			}
			
			return posts;
		}

	private User returnUser(String email) {
		return userRepo.findByEmail(email).get();
	}

	private void setAttributes(Post post, PostRequestDTO obj) {
		post.setTitle(obj.getTitle());
		post.setPostMessage(obj.getPostMessage());
	}

	private Post returnPostDataBase(Long id) {
		Post post = postRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("There is no post with id : " + id));
		return post;
	}

	//This method validates the email post owner 
	private void permissionValidation(String emailUserLogged, String ownerEmail, String msg) {

		if (!emailUserLogged.equals(ownerEmail)) {
			throw new PostOwnerException(msg);
		}

	}


}
