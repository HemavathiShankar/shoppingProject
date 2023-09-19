package com.example.productservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleException {
	@ExceptionHandler(ProductCustomException.class)
	public ResponseEntity<ErrorMessage> handleNotFound(ProductCustomException e){
		ErrorMessage em=new ErrorMessage(e.getMessage(),e.getErrorCode());
		return new ResponseEntity<>(em,HttpStatus.NOT_FOUND);
		
	}

}
