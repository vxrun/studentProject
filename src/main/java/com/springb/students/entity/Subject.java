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
	private String name;
	private int marks;
	private int totalMarks =100;
	private int studentSubjectId;
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
	public int getStudentSubjectId() {
		return studentSubjectId;
	}
	public void setStudentSubjectId(int studentSubjectId) {
		this.studentSubjectId = studentSubjectId;
	}
	@Override
	public String toString() {
		return "Subject [subjectid=" + subjectid + ", name=" + name + ", marks=" + marks + ", totalMarks=" + totalMarks
				+ ", studentSubjectId=" + studentSubjectId + "]";
	}
	
}
