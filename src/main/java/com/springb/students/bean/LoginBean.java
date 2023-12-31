package com.springb.students.bean;

import javax.persistence.Entity;
import javax.validation.constraints.Email;

@Entity
public class LoginBean {
	@Email
	String email;
	String password;
	
	
	public LoginBean(String email, String password) {
		super();
		this.email = email;
		this.password = password;
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
	
	
}
