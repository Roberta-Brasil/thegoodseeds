package com.thegoodseeds.seedsaversapp.controllers.authentication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thegoodseeds.seedsaversapp.dtos.request.LoginFormRequestDto;
import com.thegoodseeds.seedsaversapp.dtos.response.TokenDto;
import com.thegoodseeds.seedsaversapp.service.AuthenticationService;

import io.swagger.v3.oas.annotations.Operation;

@RestController   // Identificando  que é um rest-controller
@RequestMapping(value = "/auth")   // Recurso para "encontrar" esse controller
@Profile(value = {"prod", "test"})
public class AuthenticationController {
	
	@Autowired
    private AuthenticationManager authManager;    // Injeção de dependencia automatica - > AuthenticationManager
    @Autowired
    private AuthenticationService authService;  // Injeção de dependencia automatica - > AuthenticationService

    @PostMapping
    @Operation(summary = "Faz o login e se autentica no sistema.")
    public ResponseEntity<TokenDto> authenticate(@RequestBody LoginFormRequestDto form) {

        String token = authService.authenticate(form, authManager); // Hash do Token que será retornado para o Client.

        return ResponseEntity.ok(new TokenDto(token, "Bearer"));
    }

}
