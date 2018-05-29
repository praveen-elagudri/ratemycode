package com.ratemycode.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ratemycode.domain.SocialDetailsEntity;

import java.util.UUID;

public interface SocialDetailsRepository extends CrudRepository<SocialDetailsEntity, UUID> {
}
