package com.example.Product.controllerAdvice;

import com.example.Product.dtos.ErrorResponseDto;
import com.example.Product.services.InvalidProductIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ErrorResponseDto> handleArithmaticException(){
        return new ResponseEntity<>(new ErrorResponseDto("Invalid Arithmatic Expression"), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(InvalidProductIdException.class)
    public ResponseEntity<ErrorResponseDto> handleInvalidProduct(){
        return new ResponseEntity<>(new ErrorResponseDto("Invalid product"),HttpStatus.NOT_FOUND);
    }

}
