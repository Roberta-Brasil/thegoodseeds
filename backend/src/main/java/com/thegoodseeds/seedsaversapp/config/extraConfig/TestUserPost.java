package com.thegoodseeds.seedsaversapp.config.extraConfig;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;

@Configuration
@Order(value = 2)
@Profile(value = { "test" })
public class TestUserPost implements CommandLineRunner {

//	@Autowired
//	private PostRepository postRepo;
////	@Autowired
////	private CommentRepository commentsRepo;
//
//	@Autowired
//	private UserRepository userRepo;
//
//	@Autowired
//	private SeedRepository seedRepo;

	@Override
	public void run(String... args) throws Exception {

//		User eugene = new User("Eugene", "$2a$10$KT5rbfQTU8103kP6uEmkkO3W8XTc4MFH2peGPuL3sQ3X5ne.kz2oK", "eugene@hotmail.com", null, "Eugene McLaughlin", null, "photo.com", null);
//		
//		User newUser = userRepo.save(eugene);
//		
//		Post post1 = new Post(2, "Gratitude", "This is working now!");
//	
//		
//		Post post2 = new Post(5,"Seed Peróba branca","I have two perobas brancas");
//
//		post1.setUser(newUser);
//		post2.setUser(newUser);
//		Post newPost1 = postRepo.save(post1);
//		Post newPost2 = postRepo.save(post2);
//		
//
//		newUser.addPost(newPost1);
//		newUser.addPost(newPost2);
//		userRepo.save(newUser);

//		User user = new User();
//		user.setEmail("joao@hotmail.com");
//		user.setPassword("$2a$12$C0/tNE9yniJdMrfV40nnAuhn.zllXTvZr2AzmLP9Eo.2UiuPFxFa.");
//		User newUser03 = userRepo.save(user);
//
//		Seed seed = new Seed("Test","TestSpecif","FamilySpecifc",
//				TypeOfStorage.BAG_STORAGE, "seedSDesceription",".com.br","Location", LocalDate.now());
//		seed.setUser(newUser03);
//		Seed newSeed = seedRepo.save(seed);
//		
//		user.addSeed(newSeed);
//		newUser03 = userRepo.save(user);
//		
//		Post post3 = new Post(3,"Seed Peróba branca Paul","I have two perobas brancas");
//		post3.setUser(newUser03);
//		post3.setSeed(newSeed);
//		
//		Post newPost03 = postRepo.save(post3);
//		user.addPost(newPost03);
//
//		User joao = userRepo.save(user);
//		
//		System.out.println(joao);

	}

}
