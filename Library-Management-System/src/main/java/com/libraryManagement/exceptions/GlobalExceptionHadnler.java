package com.libraryManagement.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHadnler {
	
	
	// no handler found exception

	@ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<MyErrorDetails> wrongApiHandler(NoHandlerFoundException e, WebRequest wr){

		  System.out.println("Inside the NoHandlerFoundException Handler...");

		  MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), e.getMessage(), wr.getDescription(false));

		  return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);

	   }

	// method argument not valid exception

	@ExceptionHandler(MethodArgumentNotValidException.class)
	   public ResponseEntity<MyErrorDetails> methodHandler(MethodArgumentNotValidException ie,WebRequest req) {

			System.out.println("inside MethodArgumentNotValidException Handler...");

			MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), ie.getMessage(), req.getDescription(false));

			return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);


	    }
	
}
