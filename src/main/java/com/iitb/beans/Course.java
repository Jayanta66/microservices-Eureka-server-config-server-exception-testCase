package com.iitb.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="course")
public class Course {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="course_id")
	private Long course_id;
	
	@Column(name="course_title")
	private	String course_title;
	
	@Column(name="course_code")
	private	String course_code;
	
	@Column(name="description")
	private	String description;
	
	@Column(name="year")
	private	String year;
	
	@Column(name="semester")
	private	String semester;

	public Course(String course_title, String course_code, String description, String year, String semester) {
		super();
		this.course_title = course_title;
		this.course_code = course_code;
		this.description = description;
		this.year = year;
		this.semester = semester;
	}




}
