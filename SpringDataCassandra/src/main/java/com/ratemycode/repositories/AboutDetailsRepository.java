package com.ratemycode.repositories;

import com.ratemycode.domain.AboutDetailsEntity;
import com.ratemycode.model.Customer;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface AboutDetailsRepository extends CrudRepository<AboutDetailsEntity, UUID> {
	
	@Query(value="SELECT * FROM customer WHERE firstname=?0")
	public List<Customer> findById(String firstname);

	@Query("SELECT * FROM customer WHERE firstname = ?0 and lastname = ?1 ALLOW FILTERING")
	public Customer findCustomerHasAgeGreaterThan(String firstname, String lastname);
}
