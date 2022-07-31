package com.thegoodseeds.seedsaversapp.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.thegoodseeds.seedsaversapp.entities.Comments;
import com.thegoodseeds.seedsaversapp.entities.Post;
import com.thegoodseeds.seedsaversapp.repositories.CommentsRepository;
import com.thegoodseeds.seedsaversapp.repositories.PostRepository;

@Configuration
@Profile("dev")
public class TestConfig implements CommandLineRunner {

	@Autowired
	PostRepository postRepo;
	@Autowired
	CommentsRepository commentsRepo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Post post1 = new Post(2, "Gratidão", "Olá Paulo muito Obrigada por me ajudar");

		Comments comment1 = new Comments("Você é Super Muito Obrigada, e eu gosto de java...Paciência");
		Comments comment2 = new Comments("Você é Super Muito Obrigada, e eu gosto de java...Paciência");

		System.out.println(post1);
		System.out.println(comment1);
		System.out.println(comment2);

		Post newPost = postRepo.save(post1);
		System.out.println(newPost);

		comment1.setPost(newPost);

		comment2.setPost(newPost);

		Comments rc = commentsRepo.save(comment1);
		Comments rc1 = commentsRepo.save(comment2);
		
		System.out.println(rc);
//		System.out.println(rc1);
//		
//		post1.setComments(Arrays.asList(rc, rc1));
//		
//
//      
	}

}
