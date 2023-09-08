package com.springb.students.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.springb.students.entity.Subject;

@Entity
public class StudentBean {
	
	@NotNull(message = "Please provide valid first name")
	private String firstName;
	
	@NotNull(message = "Please provide valid last name")
	private String lastName;
	
	@Email(message = "Please provide valid email")
	@NotNull
	private String email;
	
	@Length(min = 8, max = 16, message = "Password length should be 8-16")
	@NotNull
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
	public StudentBean(@NotNull(message = "Please provide valid first name") String firstName,
			@NotNull(message = "Please provide valid last name") String lastName,
			@Email(message = "Please provide valid email") @NotNull String email,
			@Length(min = 8, max = 16, message = "Password length should be 8-16") @NotNull String password,
			List<Subject> subjects) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.subjects = subjects;
	}
	
	
	
	
}
