package com.thegoodseeds.seedsaversapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thegoodseeds.seedsaversapp.entities.Comments;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long> {

}
