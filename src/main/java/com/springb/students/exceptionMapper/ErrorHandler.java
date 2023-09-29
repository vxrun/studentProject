package com.springb.students.exceptionMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.Forbidden;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springb.students.exceptions.CustomAccessDeniedException;
import com.springb.students.exceptions.BadRequestDataException;
import com.springb.students.exceptions.UserAlreadyExistsException;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ErrorHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler({NullPointerException.class,Exception.class, Forbidden.class})
	ResponseEntity<String> handle(){
		log.info("---------Null Pointer Exception. Try again----------");
		return new ResponseEntity<>(
				"Found Null Pointer Exception",
				HttpStatus.OK
				);
	}

	@ExceptionHandler(BadRequestDataException.class)
	ResponseEntity<String> handleBadRequest(BadRequestDataException ex){
		log.info("---------Bad Request. Try again----------");
		return new ResponseEntity<>(
				"Bad Request. Try again.",
				HttpStatus.BAD_REQUEST
				);
	}
	
	@ExceptionHandler(CustomAccessDeniedException.class)
	ResponseEntity<String> handleAccessDenied(CustomAccessDeniedException ex){
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
				HttpStatus.OK
				);
	}
	
	@ExceptionHandler(UsernameNotFoundException.class)
	ResponseEntity<String> handleUsernameNotFound(UserAlreadyExistsException ex){
		log.info("---------Username not found. Please sign up----------");
		return new ResponseEntity<String>(
				"Username not found. Please sign up.",
				HttpStatus.BAD_REQUEST
				);
	}

}
