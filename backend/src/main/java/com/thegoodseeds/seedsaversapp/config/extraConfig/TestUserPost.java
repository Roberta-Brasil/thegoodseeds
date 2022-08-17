package com.thegoodseeds.seedsaversapp.config.extraConfig;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;

import com.thegoodseeds.seedsaversapp.entities.Post;
import com.thegoodseeds.seedsaversapp.entities.Seed;
import com.thegoodseeds.seedsaversapp.entities.User;
import com.thegoodseeds.seedsaversapp.enums.TypeOfStorage;
import com.thegoodseeds.seedsaversapp.repositories.PostRepository;
import com.thegoodseeds.seedsaversapp.repositories.SeedRepository;
import com.thegoodseeds.seedsaversapp.repositories.UserRepository;

@Configuration
@Order(value = 2)
@Profile(value = {"test"})
public class TestUserPost implements CommandLineRunner {

	@Autowired
	private PostRepository postRepo;
//	@Autowired
//	private CommentRepository commentsRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private SeedRepository seedRepo;
	

	@Override
	public void run(String... args) throws Exception {
		
		User eugene = new User("Eugene", "$2a$10$KT5rbfQTU8103kP6uEmkkO3W8XTc4MFH2peGPuL3sQ3X5ne.kz2oK", "eugene@hotmail.com", null, "Eugene McLaughlin", null, "photo.com", null);
		
		User newUser = userRepo.save(eugene);
		
		Post post1 = new Post(2, "Gratitude", "This is working now!");
	
		
		Post post2 = new Post(5,"Seed Peróba branca","I have two perobas brancas");

		post1.setUser(newUser);
		post2.setUser(newUser);
		Post newPost1 = postRepo.save(post1);
		Post newPost2 = postRepo.save(post2);
		

		newUser.addPost(newPost1);
		newUser.addPost(newPost2);
		userRepo.save(newUser);
		
		User user = new User();
		user.setEmail("joao@hotmail.com");
		user.setPassword("$2a$12$C0/tNE9yniJdMrfV40nnAuhn.zllXTvZr2AzmLP9Eo.2UiuPFxFa.");
		
		userRepo.save(user);
		
		Seed seed = new Seed(1l,"Test","TestSpecif","FamilySpecifc",
				TypeOfStorage.BAG_STORAGE, "seedSDesceription",".com.br","Location", LocalDate.now());
		
		seedRepo.save(seed);
		
	}


}
