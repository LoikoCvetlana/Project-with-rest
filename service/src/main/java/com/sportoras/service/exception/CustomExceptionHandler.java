package com.sportoras.service.exception;

import com.sportoras.service.exception.api.ApiError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

//    private final static Logger LOGGER = LogManager.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(RuntimeException ex, WebRequest request) {
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR);
        apiError.setMessage(ex.getMessage());
        apiError.setStatusDescription(apiError.getStatus().getReasonPhrase());
        apiError.setExceptionType(ex.getClass().getSimpleName());
        return handleExceptionInternal(ex,  apiError, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(EntityAlreadyExistException.class)
    protected ResponseEntity<Object> handleEntityExist(RuntimeException ex, WebRequest request) {
        ApiError apiError = new ApiError(HttpStatus.CONFLICT);
        apiError.setMessage(ex.getMessage());
        apiError.setStatusDescription(apiError.getStatus().getReasonPhrase());
        apiError.setExceptionType(ex.getClass().getSimpleName());
        return handleExceptionInternal(ex,  apiError, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(BadRequestException.class)
    protected ResponseEntity<Object> handleBadRequest(RuntimeException ex, WebRequest request) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        apiError.setMessage(ex.getMessage());
        apiError.setStatusDescription(apiError.getStatus().getReasonPhrase());
        apiError.setExceptionType(ex.getClass().getSimpleName());
        return handleExceptionInternal(ex,  apiError, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
