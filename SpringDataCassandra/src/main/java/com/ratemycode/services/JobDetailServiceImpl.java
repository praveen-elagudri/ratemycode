package com.ratemycode.services;

import com.ratemycode.commands.JobDetails;
import com.ratemycode.commands.ProductForm;
import com.ratemycode.domain.JobDetailsEntity;
import com.ratemycode.domain.LoginCredentialsEntity;
import com.ratemycode.repositories.JobDetailRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class JobDetailServiceImpl implements JobDetailService {

    private JobDetailRepository jobRepository;

    @Autowired
    public JobDetailServiceImpl(JobDetailRepository jobRepository) {
        this.jobRepository = jobRepository;
    }


    @Override
    public List<JobDetailsEntity> listAll() {
        List<JobDetailsEntity> jobDetails = new ArrayList<>();
        jobRepository.findAll().forEach(jobDetails::add); //fun with Java 8
        return jobDetails;
    }

    @Override
    public List<JobDetailsEntity> listByCompanyName(String companyName) {
        List<JobDetailsEntity> jobDetails = new ArrayList<>();
        jobRepository.findByCompanyName(companyName).forEach(jobDetails::add); 
        return jobDetails;
    }
    
   /* @Override
    public JobDetailsEntity getById(UUID id) {
        return jobRepository.findById(id).orElse(null);
    }


    @Override
    public void delete(UUID id) {
    	jobRepository.deleteById(id);

    }*/

    
    @Override
    public JobDetailsEntity saveOrUpdateJobDetailForm(JobDetails jobdetail) {
    	
    	JobDetailsEntity jobEntity = new JobDetailsEntity();
        
        if (jobdetail.getId() != null  && !StringUtils.isEmpty(jobdetail.getId())) {
            jobEntity.setId(jobdetail.getId());
        }
        
        jobEntity.setAddress(jobdetail.getAddress());
        jobEntity.setBonus(jobdetail.getBonus());
        jobEntity.setCity(jobdetail.getCity());
        jobEntity.setCountry(jobdetail.getCountry());
        jobEntity.setEducation(jobdetail.getEducation());
        jobEntity.setEmail(jobdetail.getEmail());
        jobEntity.setFax(jobdetail.getFax());
        jobEntity.setJobcategory(jobdetail.getJobcategory());
        jobEntity.setJobtitle(jobdetail.getJobtitle());
        jobEntity.setJobtype(jobdetail.getJobtype());
        jobEntity.setPhone(jobdetail.getPhone());
        jobEntity.setSalary(jobdetail.getSalary());
        jobEntity.setWebsite(jobdetail.getWebsite());
        jobEntity.setYearsExp(jobdetail.getYearsExp());
        jobEntity.setCompanyName(jobdetail.getCompanyName());
        jobEntity.setJobDescription(jobdetail.getJobDescription());
        jobEntity.setJobID(jobdetail.getJobID());
        
        JobDetailsEntity savedJobDetail = jobRepository.save(jobEntity);
        
        System.out.println("Saved Product Id: " + savedJobDetail.getId());
        return savedJobDetail;
    }
}
