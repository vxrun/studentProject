package com.springb.students.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subjectid")
	private int subjectid;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "marks")
	private int marks;
	
	private int totalMarks =100;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	@Override
	public String toString() {
		return "Subject [subjectid=" + subjectid + ", name=" + name + ", marks=" + marks + ", totalMarks=" + totalMarks
				+ ", studentSubjectId=" + "]";
	}
	
}
