package com.ratemycode.repositories;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ratemycode.domain.JobDetailsEntity;

import java.util.List;
import java.util.UUID;

public interface JobDetailRepository extends CrudRepository<JobDetailsEntity, UUID> {
	
	@Query("SELECT * FROM jobDetails WHERE company = ?0 ALLOW FILTERING")
	List<JobDetailsEntity> findByCompanyName(String companyName);
}
