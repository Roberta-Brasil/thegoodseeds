package com.thegoodseeds.seedsaversapp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thegoodseeds.seedsaversapp.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByEmail(String email);
	
//	 @Query("SELECT c FROM User e WHERE c.email = ?1")  //It checks the users' email when the users use the forgot password function
//	   public User findByEmail(String email); 
//	     
//	   public User findByResetPasswordToken(String token); //It will be used to validade the token, when the user receives the reset password link in email 

}
