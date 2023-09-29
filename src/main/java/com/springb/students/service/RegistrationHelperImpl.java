package com.springb.students.service;

public class RegistrationHelperImpl implements RegistrationHelper{

	@Override
	public boolean checkForExistingUser(String email) {
		return false;
	}
	
}
