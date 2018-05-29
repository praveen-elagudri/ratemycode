package com.ratemycode.repositories;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ratemycode.domain.LoginCredentialsEntity;

import java.util.UUID;

public interface LoginCredentialsRepository extends CrudRepository<LoginCredentialsEntity, UUID> {
	
	@Query("SELECT * FROM logindetails WHERE email = ?0 and password = ?1 ALLOW FILTERING")
	LoginCredentialsEntity findByEmailAndPassword(String email, String password);
	
}
