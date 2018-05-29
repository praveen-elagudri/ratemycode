package com.ratemycode.services;

import com.ratemycode.commands.CompanyDetails;
import com.ratemycode.domain.CompanyDetailsEntity;
import com.ratemycode.repositories.CompanyDetailsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CompanyDetailsServiceImpl implements CompanyDetailService {

    private CompanyDetailsRepository companyRepository;

    @Autowired
    public CompanyDetailsServiceImpl(CompanyDetailsRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    @Override
    public List<CompanyDetailsEntity> listAll() {
        List<CompanyDetailsEntity> companyDetails = new ArrayList<>();
        companyRepository.findAll().forEach(companyDetails::add); //fun with Java 8
        return companyDetails;
    }

   /* @Override
    public CompanyDetailsEntity getById(UUID id) {
        return companyRepository.findById(id).orElse(null);
    }
*/

    @Override
	public CompanyDetailsEntity saveOrUpdateCompanyDetailForm(CompanyDetails companyDetail) {
    	CompanyDetailsEntity companyEntity = new CompanyDetailsEntity();
        
        if (companyDetail.getId() != null  && !StringUtils.isEmpty(companyDetail.getId())) {
        	companyEntity.setId(companyDetail.getId());
        }
        
        companyEntity.setAddress(companyDetail.getAddress());
        companyEntity.setBusinesstype(companyDetail.getBusinessType());
        companyEntity.setCity(companyDetail.getCity());
        companyEntity.setCountry(companyDetail.getCountry());
        companyEntity.setCompanyname(companyDetail.getCompanyName());
        companyEntity.setEmail(companyDetail.getEmail());
        companyEntity.setDatefounded(companyDetail.getDateFounded());
        companyEntity.setFax(companyDetail.getFax());
        companyEntity.setNoofemployees(companyDetail.getNoOfEmployees());
        companyEntity.setPhone(companyDetail.getPhone());
        companyEntity.setWebsite(companyDetail.getWebsite());
        companyEntity.setBusregnumber(companyDetail.getBusRegNumber());
        companyEntity.setFburl(companyDetail.getFbURL());
        companyEntity.setGoogleurl(companyDetail.getGoogleURL());
        companyEntity.setLinkedinurl(companyDetail.getLinkedinURL());
        companyEntity.setTwitterurl(companyDetail.getTwitterURL());
        
        CompanyDetailsEntity savedCompanyDetail = companyRepository.save(companyEntity);
        
        System.out.println("Saved Product Id: " + savedCompanyDetail.getId());
        return savedCompanyDetail;
	}
    
    /*@Override
    public void delete(UUID id) {
    	companyRepository.deleteById(id);

    }*/

}
