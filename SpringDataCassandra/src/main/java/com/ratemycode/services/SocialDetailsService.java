package com.ratemycode.services;

import com.ratemycode.commands.SocialDetails;
import com.ratemycode.domain.SocialDetailsEntity;

import java.util.List;
import java.util.UUID;

public interface SocialDetailsService {

    List<SocialDetailsEntity> listAll();
/*
    SocialDetailsEntity getById(UUID id);

    void delete(UUID id);*/

    SocialDetailsEntity saveOrUpdateSocialDetailForm(SocialDetails socialDetail);
    
}

