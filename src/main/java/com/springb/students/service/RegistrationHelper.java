package com.springb.students.service;

import org.springframework.stereotype.Service;

@Service
public interface RegistrationHelper {
	public boolean checkForExistingUser(String email);
}
