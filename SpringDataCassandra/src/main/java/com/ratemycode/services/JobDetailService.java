package com.ratemycode.services;

import com.ratemycode.commands.JobDetails;
import com.ratemycode.commands.ProductForm;
import com.ratemycode.domain.JobDetailsEntity;

import java.util.List;
import java.util.UUID;

public interface JobDetailService {

    List<JobDetailsEntity> listAll();

    List<JobDetailsEntity> listByCompanyName(String companyName);
   /* JobDetailsEntity getById(UUID id);

    void delete(UUID id);
*/
    JobDetailsEntity saveOrUpdateJobDetailForm(JobDetails jobdetail);
    
}
