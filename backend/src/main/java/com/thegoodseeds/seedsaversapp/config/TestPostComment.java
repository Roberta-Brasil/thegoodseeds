package com.thegoodseeds.seedsaversapp.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;

import com.thegoodseeds.seedsaversapp.entities.Comment;
import com.thegoodseeds.seedsaversapp.entities.Post;
import com.thegoodseeds.seedsaversapp.repositories.CommentRepository;
import com.thegoodseeds.seedsaversapp.repositories.PostRepository;

@Configuration
@Order(1)
@Profile("test02")
public class TestPostComment implements CommandLineRunner {

	@Autowired
	PostRepository postRepo;
	@Autowired
	CommentRepository commentRepo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Post post1 = new Post(2, "Gratitude", "This is working now!");

		Comment comment1 = new Comment("This is a comment test 1");
		Comment comment2 = new Comment("This a comment test 2");

		System.out.println(post1);
		System.out.println(comment1);
		System.out.println(comment2);

		Post newPost = postRepo.save(post1);
		System.out.println(newPost);

		comment1.setPost(newPost);
		comment2.setPost(newPost);

		Comment rc1 = commentRepo.save(comment1);
		Comment rc2 = commentRepo.save(comment2);
		
		System.out.println(rc1);
		System.out.println(rc2);
		
		newPost.addComment(rc1);
		newPost.addComment(rc2);
		
		postRepo.save(newPost);
	}

}
