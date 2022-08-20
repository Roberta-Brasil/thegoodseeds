package com.thegoodseeds.seedsaversapp.controllers.authentications;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thegoodseeds.seedsaversapp.dtos.request.LoginFormRequestDTO;
import com.thegoodseeds.seedsaversapp.dtos.response.TokenDTO;
import com.thegoodseeds.seedsaversapp.services.AuthenticationService;

import io.swagger.v3.oas.annotations.Operation;

@CrossOrigin("*")
@RestController   // Identificando  que é um rest-controller
@RequestMapping(value = "/auth")   // Recurso para "encontrar" esse controller
@Profile(value = {"prod","test"})
public class AuthenticationController {
	
	@Autowired
    private AuthenticationManager authManager;    // Injeção de dependencia automatica - > AuthenticationManager
    @Autowired
    private AuthenticationService authService;  // Injeção de dependencia automatica - > AuthenticationService

    @PostMapping
    @Operation(summary = "Make a login and authenticated the system.")
    public ResponseEntity<TokenDTO> authenticate(@RequestBody LoginFormRequestDTO form) {

        String token = authService.authenticate(form, authManager); // Hash do Token que será retornado para o Client.

        return ResponseEntity.ok(new TokenDTO(token, "Bearer"));
    }

}
