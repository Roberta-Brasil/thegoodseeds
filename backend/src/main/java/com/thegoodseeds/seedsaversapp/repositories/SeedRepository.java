package com.thegoodseeds.seedsaversapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thegoodseeds.seedsaversapp.entities.Seed;

@Repository
public interface SeedRepository extends JpaRepository<Seed, Long> {

	List<Seed> findByPopularNameContains(String seedPopularName);

}
