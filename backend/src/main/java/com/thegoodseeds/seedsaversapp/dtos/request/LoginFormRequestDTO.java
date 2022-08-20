package com.thegoodseeds.seedsaversapp.dtos.request;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginFormRequestDTO {
	
	private String email;

   
    private String password;


    public UsernamePasswordAuthenticationToken toConvert() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
    
 
}
