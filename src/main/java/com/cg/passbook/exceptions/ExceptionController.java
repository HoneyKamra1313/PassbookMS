package com.cg.passbook.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class ExceptionController {

	
	
		@ExceptionHandler(AccNotFoundException.class)
		public String handleException(AccNotFoundException e)
		{
			return e.getMessage();
		}
		
		
		@ExceptionHandler(AccountExistException.class)
		public String AccountExistException(AccountExistException e)
		{
			return e.getMessage();
		}
		
		
				@ExceptionHandler(Exception.class)
				public ResponseEntity<ErrorMessage> genericException(Exception e) {
					ErrorMessage error=new ErrorMessage();
					error.setStatusCode(HttpStatus.BAD_REQUEST.value());
					error.setErrorMessage(e.getMessage());
					return new ResponseEntity<>(error,HttpStatus.OK);
					
					
					
					  }
				
				
				
				
				
			
		
		
		
		
		
		
	
	
}
