package com.ratemycode.services;

import com.ratemycode.commands.SocialDetails;
import com.ratemycode.domain.SocialDetailsEntity;
import com.ratemycode.repositories.SocialDetailsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SocialDetailsServiceImpl implements SocialDetailsService {

    private SocialDetailsRepository socialDetailsRepository;

    @Autowired
    public SocialDetailsServiceImpl(SocialDetailsRepository socialDetailsRepository) {
        this.socialDetailsRepository = socialDetailsRepository;
    }


    @Override
    public List<SocialDetailsEntity> listAll() {
        List<SocialDetailsEntity> socialDetails = new ArrayList<>();
        socialDetailsRepository.findAll().forEach(socialDetails::add); //fun with Java 8
        return socialDetails;
    }


   /* @Override
	public SocialDetailsEntity getById(UUID id) {
    	return socialDetailsRepository.findById(id).orElse(null);
	}
    
    @Override
    public void delete(UUID id) {
    	socialDetailsRepository.deleteById(id);

    }
*/

	@Override
	public SocialDetailsEntity saveOrUpdateSocialDetailForm(SocialDetails socialDetail) {
		SocialDetailsEntity socialEntity = new SocialDetailsEntity();
        
        if (socialEntity.getId() != null  && !StringUtils.isEmpty(socialEntity.getId())) {
        	socialEntity.setId(socialEntity.getId());
        }
        
        socialEntity.setFbURL(socialDetail.getFbURL());
        socialEntity.setGoogleURL(socialDetail.getGoogleURL());
        socialEntity.setLinkedinURL(socialDetail.getLinkedinURL());
        socialEntity.setTwitterURL(socialDetail.getTwitterURL());
        
        
        SocialDetailsEntity savedSocialEntity = socialDetailsRepository.save(socialEntity);
        
        System.out.println("Saved Product Id: " + savedSocialEntity.getId());
        return savedSocialEntity;
	}
}
