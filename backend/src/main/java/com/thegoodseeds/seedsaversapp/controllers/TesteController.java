package com.thegoodseeds.seedsaversapp.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/teste")
public class TesteController {
	
	@GetMapping
	public String get() {
		return "ok";
	}
	
    @DeleteMapping
    public String delete() {
    	return "delete";
    }
	
}
