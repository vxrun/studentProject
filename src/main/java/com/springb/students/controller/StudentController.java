package com.springb.students.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springb.students.entity.Student;
import com.springb.students.service.StudentService;

@RestController
@PreAuthorize("hasAuthority('Student')")
@RequestMapping(path = "/students")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/welcome/{rollNo}")
	public ResponseEntity<Student> welcomeStudent(@PathVariable(name = "rollNo") int rollNo){
		Student student = studentService.findByRollNo(rollNo);
		return ResponseEntity.ok().body(student);
	}
}
