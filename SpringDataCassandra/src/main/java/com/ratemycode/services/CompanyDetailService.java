package com.ratemycode.services;

import com.ratemycode.commands.CompanyDetails;
import com.ratemycode.domain.CompanyDetailsEntity;

import java.util.List;
import java.util.UUID;

public interface CompanyDetailService {

    List<CompanyDetailsEntity> listAll();
/*
    CompanyDetailsEntity getById(UUID id);

    void delete(UUID id);*/

    CompanyDetailsEntity saveOrUpdateCompanyDetailForm(CompanyDetails companyDetail);
    
}
