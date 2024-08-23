package com.iitb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iitb.beans.Course;
import com.iitb.exception.NoDataException;
import com.iitb.exception.TaskNotFoundException;
import com.iitb.service.SupplierService;


@RestController
@CrossOrigin("http://localhost:3000")
public class AppController {
	@Autowired
	private SupplierService service;

	@GetMapping("/")
	public String home() {
		return "Welcome to The Course Management Application";
	}

	@PostMapping("/api/courses")
	public ResponseEntity<?> addTask(@RequestBody Course task) {
		boolean tas = service.save(task);
		return new ResponseEntity<>(task, HttpStatus.CREATED);
	}

	@GetMapping("/api/courses")
	public ResponseEntity<?> getTask() throws NoDataException {
		List<Course> list = service.listAll();
		if ((!list.isEmpty()))
			return new ResponseEntity<>(list, HttpStatus.OK);
		else
			throw new NoDataException("No Data Found");
	}

	@GetMapping("/api/courses/{course_id}")
	public ResponseEntity<?> getCustomerById(@PathVariable("course_id") long course_id) throws TaskNotFoundException {
		String noCourse = "No Course Details has found";
		Course Course = service.get(course_id);
		if (Course != null) {
			return new ResponseEntity<>(Course, HttpStatus.OK);
		}
		throw new TaskNotFoundException(noCourse);
	}

	@PutMapping("/api/courses/{course_id}")
	public String updateCourse(@PathVariable long course_id, @RequestBody Course course) {
		String noCustomers = "No Customers Details found";
		String updateddSuccess = "Successfully Updated";

		boolean updated = service.save(course);
		if (!updated) {
			return updateddSuccess;		
			}
	//	return new TaskNotFoundException(noCustomers);
		return noCustomers;

	}

	@DeleteMapping("/api/courses/{course_id}")
	public ResponseEntity<?> deleteAllCustomers(@PathVariable Long course_id) throws TaskNotFoundException {
		boolean deleted = service.delete(course_id);
		if (deleted) {
			return new ResponseEntity<>("Successfully Deleted", HttpStatus.OK);
		}
		else throw new TaskNotFoundException("No Customers Details found");

	}

}
