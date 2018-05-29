package com.ratemycode.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ratemycode.domain.CompanyDetailsEntity;

import java.util.UUID;

public interface CompanyDetailsRepository extends CrudRepository<CompanyDetailsEntity, UUID> {
}
