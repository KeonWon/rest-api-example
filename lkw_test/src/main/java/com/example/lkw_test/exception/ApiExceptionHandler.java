package com.example.lkw_test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleException(NotFoundException ex) {
        ApiErrorResponse response =
                new ApiErrorResponse("404", "br code not found error");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}