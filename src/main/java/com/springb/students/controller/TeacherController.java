package com.springb.students.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springb.students.service.StudentService;

@RestController
@PreAuthorize("hasAuthority('teacher')")
@RequestMapping(path = "/teacher")
public class TeacherController {
	@Autowired
	StudentService studentService;
	
	@GetMapping("/welcome")
	public ResponseEntity<String> welcomeStudent(Authentication authentication){
		String username = authentication.getName();
		String returnValue;
		returnValue = "Welcome teacher " + username + " to the welcome page.";
		return ResponseEntity.ok().body(returnValue);
	}
}
