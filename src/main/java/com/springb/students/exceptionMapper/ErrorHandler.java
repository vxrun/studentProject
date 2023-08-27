package com.springb.students.exceptionMapper;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springb.students.exceptions.BadRequestDataException;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(value = { BadRequestDataException.class, IllegalStateException.class })
	protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
		System.out.println("JJJJJJJJJJJJ");
		String bodyOfResponse = "This should be application specific";
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

//	@ExceptionHandler(BadRequestDataException.class)
//	ResponseEntity<String> handleBadRequest(BadRequestDataException ex){
//		System.out.println("gggggggggggggggggggggg");
//		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//	}
//
}
