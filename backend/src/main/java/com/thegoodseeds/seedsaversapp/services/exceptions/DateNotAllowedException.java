package com.thegoodseeds.seedsaversapp.services.exceptions;

public class DateNotAllowedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DateNotAllowedException(String msg) {
		super(msg);
	}

}
