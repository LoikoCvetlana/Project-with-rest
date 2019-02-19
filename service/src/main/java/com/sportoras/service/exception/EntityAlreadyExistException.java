package com.sportoras.service.exception;

public class EntityAlreadyExistException extends RuntimeException{

    public EntityAlreadyExistException(String message) {
        super(message);
    }

    public EntityAlreadyExistException(Throwable cause) {
        super(cause);
    }

    public EntityAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
