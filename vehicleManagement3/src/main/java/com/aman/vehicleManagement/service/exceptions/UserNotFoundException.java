package com.aman.vehicleManagement.service.exceptions;

public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(String message) {
        super(message);
    }
}
