package com.ratemycode.services;

import com.ratemycode.commands.AboutDetails;
import com.ratemycode.domain.AboutDetailsEntity;
import com.ratemycode.repositories.AboutDetailsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AboutDetailsServiceImpl implements AboutDetailsService {

    private AboutDetailsRepository aboutRepository;

    @Autowired
    public AboutDetailsServiceImpl(AboutDetailsRepository aboutRepository) {
        this.aboutRepository = aboutRepository;
    }


    @Override
    public List<AboutDetailsEntity> listAll() {
        List<AboutDetailsEntity> aboutDetails = new ArrayList<>();
        aboutRepository.findAll().forEach(aboutDetails::add); //fun with Java 8
        return aboutDetails;
    }

    /*@Override
    public AboutDetailsEntity getById(UUID id) {
        //return aboutRepository.findById(id).orElse(null);
        
        return aboutRepository.findById(id);
    }*/


   /* @Override
    public void delete(UUID id) {
    	aboutRepository.deleteById(id);

    }*/

    
    @Override
    public AboutDetailsEntity saveOrUpdateAboutDetailForm(AboutDetails aboutDetail) {
    	
    	AboutDetailsEntity aboutEntity = new AboutDetailsEntity();
        
        if (aboutDetail.getId() != null  && !StringUtils.isEmpty(aboutDetail.getId())) {
        	aboutEntity.setId(aboutDetail.getId());
        }
        
        aboutEntity.setProfileVisibility(aboutDetail.getProfileVisibility());
        aboutEntity.setYearOfExp(aboutDetail.getYearOfExp());
        
        AboutDetailsEntity savedAboutDetail = aboutRepository.save(aboutEntity);
        
        System.out.println("Saved Product Id: " + savedAboutDetail.getId());
        return savedAboutDetail;
    }
}

