package com.iitb;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import org.springframework.test.annotation.Rollback;

import com.iitb.beans.Course;
import com.iitb.repository.SupplierRepository;





@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class SupplierRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;

	@Autowired	
	private SupplierRepository supplierRepository;
	
	@Test
	public void testCreateSupplier() {
		Course supplier = new Course("Java Full Web Development","Java Develper","Completed","dfasdf","adsfdfs");	
		Course savedsupplier = supplierRepository.save(supplier);
		System.out.println("Task Created Successfully "+supplier);
		assertThat(savedsupplier.getCourse_id()).isGreaterThan(0);

	}
	

	@Test
	public void testListAllSupplier() {
		Iterable<Course> listsupplier = supplierRepository.findAll();
		System.out.println("List has found successfully");
		listsupplier.forEach(supplier -> System.out.println(supplier));
	}
	
	@Test
	public void testGetSupplierById() {
		Course supplier = supplierRepository.findById((long) 5).get();
		System.out.println(supplier);
		assertThat(supplier).isNotNull();
	}
	
	@Test
	public void testUpdateSupplierDetails() {
		Course supplier = supplierRepository.findById((long) 5).get();
		supplier.setCourse_title("Compuer Science and Engineering");
		supplier.setCourse_code("CSE20204");
		supplier.setDescription("Computer Science");	
		supplier.setYear("2024");
		supplier.setSemester("1st");
		System.out.println("Updated Successfully");
		System.out.println(supplierRepository.save(supplier));

	}
	
	@Test
	public void testDeleteSupplier() {
		Long supplierId = (long) 6;
		supplierRepository.deleteById(supplierId);
		System.out.println("Deleted Successfully");

		
	}
	


}
