package com.sportoras.service.exception;

public class EntityDidntSaveException extends RuntimeException{

    public EntityDidntSaveException(String message) {
        super(message);
    }

    public EntityDidntSaveException(Throwable cause) {
        super(cause);
    }

    public EntityDidntSaveException(String message, Throwable cause) {
        super(message, cause);
    }
}
