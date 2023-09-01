package com.springb.students.bean;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class TeacherBean {

	@NotNull(message = "Please provide valid first name")
	private String firstName;
	
	@NotNull(message = "Please provide valid last name")
	private String lastName;
	
	@Email(message = "Please provide valid email")
	private String email;
	
	@NotNull(message = "Please provide valid number")
	private int totalStudents;
	
	@Length(min = 8, max = 16, message = "Password length should be 8-16")
	private String password;

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

	public int getTotalStudents() {
		return totalStudents;
	}

	public void setTotalStudents(int totalStudents) {
		this.totalStudents = totalStudents;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TeacherBean(@NotNull(message = "Please provide valid first name") String firstName,
			@NotNull(message = "Please provide valid last name") String lastName,
			@Email(message = "Please provide valid email") String email,
			@NotNull(message = "Please provide valid number") int totalStudents,
			@Length(min = 8, max = 16, message = "Password length should be 8-16") String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.totalStudents = totalStudents;
		this.password = password;
	}
	
	
}
