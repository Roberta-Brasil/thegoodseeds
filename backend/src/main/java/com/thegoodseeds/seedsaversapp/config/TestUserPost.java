package com.thegoodseeds.seedsaversapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;

import com.thegoodseeds.seedsaversapp.entities.Post;
import com.thegoodseeds.seedsaversapp.entities.User;
import com.thegoodseeds.seedsaversapp.repositories.CommentRepository;
import com.thegoodseeds.seedsaversapp.repositories.PostRepository;
import com.thegoodseeds.seedsaversapp.repositories.UserRepository;

@Configuration
@Order(2)
@Profile("test")
public class TestUserPost implements CommandLineRunner {

	@Autowired
	PostRepository postRepo;
	@Autowired
	CommentRepository commentsRepo;
	
	@Autowired
	UserRepository userRepo;

	@Override
	public void run(String... args) throws Exception {
		
		User paulo = new User("Paulo", "pbss", "pbsee@hotmail.com", null, "Paulo Soares", null, null, "21986574123");
		
		User newUser = userRepo.save(paulo);
		System.out.println(newUser);
		
		Post post1 = new Post(2, "Gratitude", "This is working now!");
		System.out.println(post1);

		post1.setUser(newUser);
		Post newPost = postRepo.save(post1);
		System.out.println(newPost);

		newUser.onePost(newPost);
		userRepo.save(newUser);
		
	}

}
