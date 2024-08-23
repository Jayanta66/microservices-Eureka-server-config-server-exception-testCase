package com.iitb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.iitb.beans.Course;


public interface SupplierRepository extends JpaRepository<Course, Long> {
		
//	@Query("SELECT j FROM Course j WHERE CONCAT(j.Course, ' ',j.company_name, ' ', j.website, ' ', j.location,' ', j.nature_of_business,' ', j.manufacturing_processes) LIKE %?1%")
//	public List<Course> search(String keyword);


//	Optional<Product> findById(long id);
	
}