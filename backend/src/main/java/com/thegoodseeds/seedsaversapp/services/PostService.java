package com.thegoodseeds.seedsaversapp.services;

import java.security.Principal;
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

	public List<PostResponseDto> findAll() {

		List<Post> posts = postRepo.findAll();

		List<PostResponseDto> postsDto = posts.stream().map(PostResponseDto::new).collect(Collectors.toList());

		return postsDto;
	}

	public PostResponseDto findById(Long id) {

		Post post = returnPostDataBase(id);

		return new PostResponseDto(post);
	}

	public PostResponseDto insert(PostRequestDto obj, Principal principal) {

		Post post = new Post();
		setAttributes(post, obj);
		User user = returnUser(principal.getName());
		post.setUser(user);

		post = postRepo.save(post);

		Seed seed = seedRepo.findById(obj.getSeedIdDto().getId()).get();

		seed.setPost(post);
		seed = seedRepo.save(seed);

		post.setSeed(seed);
		post = postRepo.save(post);

		user.addPost(post);
		userRepo.save(user);

		return new PostResponseDto(post);

	}

	public PostResponseDto update(Long id, PostRequestDto obj, Principal user) {

		Post post = returnPostDataBase(id);

		String emailUserLogged = user.getName(); // esse getName retorna o email do Usuário logado.

		String ownerEmail = post.getUser().getUsername();

		String err = "This post does not belong to you, just the post owner can update this post. ";

		permissionValidation(emailUserLogged, ownerEmail, err);

		setAttributes(post, obj);

		post = postRepo.save(post);

		return new PostResponseDto(post);
	}

	public String delete(Long id, Principal user) {

		Post post = returnPostDataBase(id);

		String emailUserLogged = user.getName(); // This getName returns email from logged user.

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

	public PostResponseDto commentingPost(Long id, CommentRequestDto obj, Principal principal) {

		Post post = returnPostDataBase(id);

		Comment comment = new Comment();

		comment.setCommentMessage(obj.getMessage());
		comment.setPost(post);

		User user = returnUser(principal.getName());

		userRepo.save(user);

		comment.setUser(user);

		commentRepo.save(comment);

		post.addComment(comment);
		user.getComments().add(comment);

		userRepo.save(user);

		post = postRepo.save(post);

		return new PostResponseDto(post);
	}

	private User returnUser(String email) {
		return userRepo.findByEmail(email).get();
	}

	private void setAttributes(Post post, PostRequestDto obj) {
		post.setTitle(obj.getTitle());
		post.setPostMessage(obj.getPostMessage());
	}

	private Post returnPostDataBase(Long id) {
		Post post = postRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("There is no post with id : " + id));
		return post;
	}

	private void permissionValidation(String emailUserLogged, String ownerEmail, String msg) {

		if (!emailUserLogged.equals(ownerEmail)) {
			throw new PostOwnerException(msg);
		}

	}

}
