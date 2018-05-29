package com.ratemycode.services;

import com.ratemycode.commands.LoginCredentials;
import com.ratemycode.domain.LoginCredentialsEntity;
import com.ratemycode.repositories.LoginCredentialsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Service
public class LoginCredentialsServiceImpl implements LoginCredentialService {

    private LoginCredentialsRepository loginRepository;

    @Autowired
    public LoginCredentialsServiceImpl(LoginCredentialsRepository loginRepository) {
        this.loginRepository = loginRepository;
    }
    
    @Override
	public boolean userExists(String email, String password) {
    	
    	LoginCredentialsEntity login = loginRepository.findByEmailAndPassword(email, password);
    	if(login != null) {
    		return true;
    	}
		/*String hql = "FROM Customers as customer WHERE customer.email = ? and customer.password = ?";
		int count = entityManager.createQuery(hql).setParameter(1, email)
		              .setParameter(2, password).getResultList().size();*/
		return false;
	}
	
	/*@Override
	public boolean userExists(String email) {
		String hql = "FROM Customers as customer WHERE customer.email = ?";
		int count = entityManager.createQuery(hql).setParameter(1, email).getResultList().size();
		return count > 0 ? true : false;
	}*/
	

    /*@Override
    public LoginCredentialsEntity getById(UUID id) {
        return loginRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(UUID id) {
    	loginRepository.deleteById(id);

    }*/
    
	@Override
	public LoginCredentialsEntity saveOrUpdateLoginDetailForm(LoginCredentials loginCredentials) {

		LoginCredentialsEntity loginEntity = new LoginCredentialsEntity();
        
        if (loginEntity.getId() != null  && !StringUtils.isEmpty(loginEntity.getId())) {
        	loginEntity.setId(loginEntity.getId());
        }
        
        loginEntity.setEmail(loginCredentials.getEmail());
        loginEntity.setPassword(loginEntity.getPassword());
        
        LoginCredentialsEntity savedLoginEntity = loginRepository.save(loginEntity);
        
        System.out.println("Saved Product Id: " + savedLoginEntity.getId());
        return savedLoginEntity;
	}

	
}
