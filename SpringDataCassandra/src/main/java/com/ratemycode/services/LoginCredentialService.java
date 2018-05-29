package com.ratemycode.services;

import com.ratemycode.commands.LoginCredentials;
import com.ratemycode.domain.LoginCredentialsEntity;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public interface LoginCredentialService {

	boolean userExists(String email, String password);
    /*boolean userExists(String email);*/
    
	
    //LoginCredentialsEntity getById(UUID id);

    //void delete(UUID id);

    LoginCredentialsEntity saveOrUpdateLoginDetailForm(LoginCredentials loginCredentials);
    
}

