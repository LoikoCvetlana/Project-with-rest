package com.sportoras.service.exception;

import com.sportoras.service.exception.api.ApiError;
import org.apache.log4j.Logger;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    private Logger LOGGER = Logger.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(RuntimeException ex, WebRequest request) {
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR);
        apiError.setMessage(ex.getMessage());
        apiError.setStatusDescription(apiError.getStatus().getReasonPhrase());
        apiError.setExceptionType(ex.getClass().getSimpleName());
        LOGGER.error("Entity not found");
        return handleExceptionInternal(ex,  apiError, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(EntityAlreadyExistException.class)
    protected ResponseEntity<Object> handleEntityExist(RuntimeException ex, WebRequest request) {
        ApiError apiError = new ApiError(HttpStatus.CONFLICT);
        apiError.setMessage(ex.getMessage());
        apiError.setStatusDescription(apiError.getStatus().getReasonPhrase());
        apiError.setExceptionType(ex.getClass().getSimpleName());
        LOGGER.error("Entity already exist.");
        return handleExceptionInternal(ex,  apiError, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler({BadRequestException.class, DataIntegrityViolationException.class, DataIntegrityViolationException.class})
    protected ResponseEntity<Object> handleBadRequest(RuntimeException ex, WebRequest request) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        apiError.setMessage(ex.getMessage());
        apiError.setStatusDescription(apiError.getStatus().getReasonPhrase());
        apiError.setExceptionType(ex.getClass().getSimpleName());
        LOGGER.error("Bad request.");
        return handleExceptionInternal(ex,  apiError, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(EntityDidntSaveException.class)
    protected ResponseEntity<Object> handleEnriryDidntSave(RuntimeException ex, WebRequest request) {
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR);
        apiError.setMessage(ex.getMessage());
        apiError.setStatusDescription(apiError.getStatus().getReasonPhrase());
        apiError.setExceptionType(ex.getClass().getSimpleName());
        LOGGER.error("Entity not saved.");
        return handleExceptionInternal(ex,  apiError, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
