package com.thegoodseeds.seedsaversapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.thegoodseeds.seedsaversapp.entities.User;
import com.thegoodseeds.seedsaversapp.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
    private UserRepository userRepo;	
	
	 @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { // Método que mostra pro spring security como será feita a autenticação.
	        Optional<User> user = userRepo.findByEmail(username);
	        return user.get();
	    }

}
