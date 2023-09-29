package com.springb.students.exceptions;

import java.nio.file.AccessDeniedException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class CustomAccessDeniedException extends AccessDeniedException{

	private static final long serialVersionUID = 1L;

	public CustomAccessDeniedException(String file) {
		super(file);
	}

}
