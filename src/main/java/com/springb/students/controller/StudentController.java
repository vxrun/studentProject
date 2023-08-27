package com.springb.students.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springb.students.bean.RequestBean;
import com.springb.students.entity.Student;
import com.springb.students.exceptions.BadRequestDataException;
import com.springb.students.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService studentService;

	// POST METHODS
	@RequestMapping(path = "/saveStudent", method = RequestMethod.POST)
	public Student createStudent(@RequestBody Student student) {
		studentService.saveStudent(student);
		// Return a response indicating success
		return student;
	}

	@RequestMapping(path = "/saveStudentsss", method = RequestMethod.POST)
	public ResponseEntity<Student> createStudentsss(@RequestBody @Valid RequestBean requestBean) {

		System.out.println(requestBean.toString());
		if (requestBean.getFirstName().equals("ABC")) {
			throw new BadRequestDataException();
		}
		Student student = new Student();

		BeanUtils.copyProperties(requestBean, student);
		System.out.println(student);
		studentService.saveStudent(student);
		return ResponseEntity.ok().body(student);
	}
}
