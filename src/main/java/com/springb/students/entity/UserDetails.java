package com.springb.students.entity;

import java.io.Serializable;

public interface UserDetails extends Serializable{
	String getUsername();
	String getPassword();

}
