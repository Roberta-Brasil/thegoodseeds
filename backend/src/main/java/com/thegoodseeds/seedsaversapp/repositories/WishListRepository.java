package com.thegoodseeds.seedsaversapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thegoodseeds.seedsaversapp.entities.WishList;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Long> {

}
