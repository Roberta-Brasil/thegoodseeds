package com.thegoodseeds.seedsaversapp.controllers.exceptionConfigs;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.thegoodseeds.seedsaversapp.services.exceptions.DataBaseException;
import com.thegoodseeds.seedsaversapp.services.exceptions.EmailAlreadyExistsException;
import com.thegoodseeds.seedsaversapp.services.exceptions.PostOwnerException;
import com.thegoodseeds.seedsaversapp.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(status.value(),error,e.getMessage(),request.getRequestURI());
			
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandardError> dataBase(DataBaseException e, HttpServletRequest request) {
		
		String error = "Error Login";
		HttpStatus status = HttpStatus.NOT_ACCEPTABLE; // Achar um status http mais adequado.
		StandardError err = new StandardError(status.value(),error,e.getMessage(),request.getRequestURI());
			
		return ResponseEntity.status(status).body(err);
	}
	

	@ExceptionHandler(PostOwnerException.class)
	public ResponseEntity<StandardError>postOwner(PostOwnerException e, HttpServletRequest request) {
		
		String error = "User unauthorized to access.";
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		StandardError err = new StandardError(status.value(),error,e.getMessage(),request.getRequestURI());
			
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(EmailAlreadyExistsException.class)
	public ResponseEntity<StandardError> emailAlreadyExists(EmailAlreadyExistsException e, HttpServletRequest request) {
		
		String error = "Email already exists in the system";
		HttpStatus status = HttpStatus.NOT_ACCEPTABLE; // Achar um status http mais adequado.
		StandardError err = new StandardError(status.value(),error,e.getMessage(),request.getRequestURI());
			
		return ResponseEntity.status(status).body(err);
	}


}
