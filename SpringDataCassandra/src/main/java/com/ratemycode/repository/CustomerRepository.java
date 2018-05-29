package com.ratemycode.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ratemycode.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String> {
	
	@Query(value="SELECT * FROM customer WHERE firstname=?0")
	public List<Customer> findByFirstname(String firstname);

	@Query("SELECT * FROM customer WHERE firstname = ?0 and lastname = ?1 ALLOW FILTERING")
	public Customer findCustomerHasAgeGreaterThan(String firstname, String lastname);
}