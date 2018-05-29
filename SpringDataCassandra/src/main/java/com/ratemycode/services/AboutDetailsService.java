package com.ratemycode.services;

import com.ratemycode.commands.AboutDetails;
import com.ratemycode.domain.AboutDetailsEntity;

import java.util.List;
import java.util.UUID;

public interface AboutDetailsService {

    List<AboutDetailsEntity> listAll();

   /* AboutDetailsEntity getById(UUID id);

    void delete(UUID id);*/

    AboutDetailsEntity saveOrUpdateAboutDetailForm(AboutDetails aboutDetails);
    
}
