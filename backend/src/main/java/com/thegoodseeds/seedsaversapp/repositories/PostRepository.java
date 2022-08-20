package com.thegoodseeds.seedsaversapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thegoodseeds.seedsaversapp.entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

  //Paulo public Optional<List>post;
//	
//	@Query(value = "SELECT * FROM tb_posts p WHERE p.title LIKE '%Gratitude%'", nativeQuery = true)
//	List<Post> findAllPost(@Param("param") String param);
	
}
