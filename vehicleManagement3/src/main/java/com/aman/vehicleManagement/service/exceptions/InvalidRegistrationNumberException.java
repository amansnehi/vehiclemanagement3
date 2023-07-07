package com.aman.vehicleManagement.service.exceptions;

public class InvalidRegistrationNumberException extends RuntimeException{
	public InvalidRegistrationNumberException(String message) {
        super(message);
    }
}
