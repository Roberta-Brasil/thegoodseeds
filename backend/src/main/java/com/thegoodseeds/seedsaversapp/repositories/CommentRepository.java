package com.thegoodseeds.seedsaversapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thegoodseeds.seedsaversapp.entities.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
