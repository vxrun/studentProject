package com.springb.students.bean;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.springb.students.entity.Subject;

public class RequestBean {
	
	@NotNull
	private String firstName;
	
	@NotNull(message = "Pease provide lastName")
	private String lastName;
	
	private String email;
	
	private String password;
	private List<Subject> subjects;
	
	@Override
	public String toString() {
		return "RequestBean [ firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", subjects=" + subjects + "]";
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
	
}
