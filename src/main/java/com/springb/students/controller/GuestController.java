package com.springb.students.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuestController {

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String getWelcomePage() {
		return "Hello There!";
	}
	
	@PreAuthorize("hasAnyAuthority('student', 'teacher', 'admin')")
	@GetMapping("/greeting")
	public String greeting(Authentication authentication) {
		String userName = authentication.getName();
		String princripal = authentication.getPrincipal().toString();
		return "Spring Security In-memory Authentication Example - Welcome " + userName + " ** " + princripal;
	}

}
