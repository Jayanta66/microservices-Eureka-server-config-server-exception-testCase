package com.iitb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iitb.beans.Course;
import com.iitb.repository.SupplierRepository;

@Service
public class SupplierService {
	@Autowired
	private SupplierRepository repo;
	
	public List<Course> listAll() {
				return repo.findAll();
	}
	
	public List<Course> listAll(String keyword) {
		return repo.findAll();
	}
	
//	public void save(Course course) {
//		return repo.save(course);
//	}
	
	public boolean save(Course course) {
		repo.save(course);
		return false;
	}
	
	public Course get(Long course_id) {
		return repo.findById(course_id).get();
	}
	
	public boolean delete(Long course_id) {
		repo.deleteById(course_id);
		return true;
	}

	public boolean existsById(Long course_id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Course updateCourseById(Long course_id, Course course) {
		Optional<Course> getCustomer = repo.findById(course_id);
		if(getCustomer.isPresent()) {
			Course foundCourse = getCustomer.get();
			foundCourse.setCourse_title(course.getCourse_title());
			foundCourse.setCourse_code(course.getCourse_code());
			foundCourse.setDescription(course.getDescription());
			foundCourse.setYear(course.getYear());
			foundCourse.setSemester(course.getSemester());
			Course updatedCourse = repo.save(foundCourse);
			return updatedCourse;
		}
		return null;
	}

	
	
//	public Course updateTask(Long Id, Course course) {
//		Course foundCourse = null;
//		Optional ac=repo.findById(Id);
//		if(ac.isPresent()) {
//			foundCourse=(Course) ac.get();
//			foundCourse.setCourse_title(course.getCourse_title());
//			foundCourse.setCourse_code(course.getCourse_code());
//			foundCourse.setDescription(course.getDescription());
//			foundCourse.setYear(course.getYear());
//			foundCourse.setSemester(course.getSemester());
//			
//
//		    return	repo.save(foundCourse);		
//		}	
//		else
//		return null;
//	}
	
}
