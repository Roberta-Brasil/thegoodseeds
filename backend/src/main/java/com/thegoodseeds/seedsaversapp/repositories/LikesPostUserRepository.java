package com.thegoodseeds.seedsaversapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thegoodseeds.seedsaversapp.entities.LikesPostUser;

@Repository
public interface LikesPostUserRepository extends JpaRepository<LikesPostUser, Long> {

}
