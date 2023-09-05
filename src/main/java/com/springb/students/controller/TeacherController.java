package com.springb.students.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasAuthority('Teacher')")
@RequestMapping(path = "/teachers")
public class TeacherController {
	
}
