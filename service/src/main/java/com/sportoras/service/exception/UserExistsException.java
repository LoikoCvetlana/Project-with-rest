package com.sportoras.service.exception;

public class UserExistsException extends RuntimeException {

    public UserExistsException (String email) {
        super("User " + email + " already exists!");
    }
}