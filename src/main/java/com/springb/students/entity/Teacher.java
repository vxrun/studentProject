package com.springb.students.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Teachers")
public class Teacher {
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "totalStudents")
	private int totalStudents;

	//constructor
	
	
	public Teacher(String firstName, String lastName, int totalStudents) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.totalStudents = totalStudents;
	}

	public Teacher(String firstName, String lastName, String email, String password, int totalStudents) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.totalStudents = totalStudents;
	}

	public Teacher() {
		super();
	}
	
	//getters and setters
	public int getId() {
		return id;
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

	public void setId(int id) {
		this.id = id;
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

	public int getTotalStudents() {
		return totalStudents;
	}

	public void setTotalStudents(int totalStudents) {
		this.totalStudents = totalStudents;
	}

	

}
