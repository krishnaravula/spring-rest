package com.sai.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    ResponseEntity<PlayerErrorResponse> handlePlayerNotFoundException(PlayerNotFound pnfe){
        PlayerErrorResponse errorResponse = new PlayerErrorResponse();
        errorResponse.setMessage(pnfe.getMessage());
        errorResponse.setStatus(HttpStatus.NO_CONTENT.value());
        errorResponse.setLocalDateTime(LocalDateTime.now());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);


    }

    @ExceptionHandler
    ResponseEntity<PlayerErrorResponse>  handlePlayerNotFoundException(MethodArgumentNotValidException pnfe){
        PlayerErrorResponse errorResponse = new PlayerErrorResponse();
        errorResponse.setMessage(pnfe.getBindingResult().getFieldError().getDefaultMessage());
        errorResponse.setStatus(HttpStatus.NO_CONTENT.value());
        errorResponse.setLocalDateTime(LocalDateTime.now());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);


    }

}
