package com.thegoodseeds.seedsaversapp.services;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.thegoodseeds.seedsaversapp.dtos.request.LoginFormRequestDTO;
import com.thegoodseeds.seedsaversapp.services.exceptions.DataBaseException;

import org.springframework.security.core.AuthenticationException;

@Service
@Profile(value = {"prod","test","dev02"})
public class AuthenticationService {
	
	@Autowired
    private TokenService tokenService;


    public String authenticate(LoginFormRequestDTO form, AuthenticationManager authManager) { // Método para fazer o login e se autenticar no sistema.

        UsernamePasswordAuthenticationToken loginData = form.toConvert();   // converter os dados passado pelo usuario em um token de autenticação
        
        try {
            Authentication authentication = authManager.authenticate(loginData); // autenticar usuário com base nos dados informados por ele
            return tokenService.generateToken(authentication);      // geração do token .
        } catch (AuthenticationException e) {
        	 throw new DataBaseException("E-mail and / or password is / are wrong!");       // Causará um erro caso os dados passados pelo usuário estejam errados.
        }
  
    }

}
