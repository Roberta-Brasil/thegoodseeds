package com.thegoodseeds.seedsaversapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.thegoodseeds.seedsaversapp.repositories.CommentRepository;
import com.thegoodseeds.seedsaversapp.repositories.PostRepository;

@Configuration
@Profile("test")
public class TestUserPost implements CommandLineRunner {

	@Autowired
	PostRepository postRepo;
	@Autowired
	CommentRepository commentsRepo;

	@Override
	public void run(String... args) throws Exception {
		
	}

}
