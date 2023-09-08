package com.springb.students.exceptionMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springb.students.exceptions.AccessDeniedException;
import com.springb.students.exceptions.BadRequestDataException;
import com.springb.students.exceptions.UserAlreadyExistsException;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ErrorHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(BadRequestDataException.class)
	ResponseEntity<String> handleBadRequest(BadRequestDataException ex){
		log.info("---------Bad Request. Try again----------");
		return new ResponseEntity<>(
				"Bad Request. Try again.",
				HttpStatus.BAD_REQUEST
				);
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	ResponseEntity<String> handleAccessDenied(AccessDeniedException ex){
		log.info("---------Access denied. please login before accessing----------");
		return new ResponseEntity<>(
				"Access denied. please login before accessing.",
				HttpStatus.FORBIDDEN
				);
	}
	
	@ExceptionHandler(UserAlreadyExistsException.class)
	ResponseEntity<String> handleUserAlreadyExists(UserAlreadyExistsException ex){
		log.info("---------User Already exists. Please log in----------");
		return new ResponseEntity<String>(
				"User Already exists. Please log in.",
				HttpStatus.BAD_REQUEST
				);
	}

}
