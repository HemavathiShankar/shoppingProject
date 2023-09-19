package com.example.productservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCustomException extends RuntimeException{
	private String errorCode;
	
	public ProductCustomException(String message,String errorCode) {
		super(message);
		this.errorCode=errorCode;
		
	}
	

}
