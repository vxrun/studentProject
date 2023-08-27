package com.springb.students.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springb.students.entity.Teacher;
import com.springb.students.service.TeacherService;

@RestController
public class TeacherController {
	@Autowired
	TeacherService teacherService;

	//GET METHODS
	// creates new teacher
	@GetMapping("/newteacher/{firstName}/{lastName}/{students}")
	public String createTeacher(
			@PathVariable(value = "firstName") String firstName,
			@PathVariable(value = "lastName") String lastName, 
			@PathVariable(value = "students") int students) {
		teacherService.createTeacher(firstName, lastName, students);
		return "Student saved successfully";
	}

	@GetMapping("/newteacher")
	public String createTeacherByRM(
			@RequestParam(value = "firstName") String firstName,
			@RequestParam(value = "lastName") String lastName, 
			@RequestParam(value = "students") int students) {
		teacherService.createTeacher(firstName, lastName, students);
		return "Student saved successfully";
	}

	@GetMapping("/newteachers")
	public String createTeacherByPM(@PathParam(
			value = "firstName") String firstName,
			@PathParam(value = "lastName") String lastName, 
			@PathParam(value = "students") int students) {
		teacherService.createTeacher(firstName, lastName, students);
		return "Student saved successfully";
	}

	@GetMapping("/allteachers")
	public List<Teacher> showAllTeachers() {
		return teacherService.showAllTeachers();
	}
	
	
	//POST METHODS
}
