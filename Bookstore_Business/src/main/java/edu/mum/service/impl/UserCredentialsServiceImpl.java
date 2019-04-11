package edu.mum.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.security.access.prepost.PreAuthorize;
import java.util.List;

import edu.mum.dao.UserCredentialsDao;
import edu.mum.domain.UserCredentials;
import edu.mum.service.UserCredentialsService;

@Service
@Transactional 
public class UserCredentialsServiceImpl implements UserCredentialsService {
	
 	@Autowired
	private UserCredentialsDao userCredentialsDao;

// 	@PreAuthorize("hasRole('ROLE_ADMIN')")
     public void save( UserCredentials userCredentials) {  
 		
 		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();   		
  		String encodedPassword = passwordEncoder.encode(userCredentials.getPassword());
  		userCredentials.setPassword(encodedPassword);
 		
  		userCredentialsDao.save(userCredentials);
 	}
  	
	public List<UserCredentials> findAll() {
		return (List<UserCredentials>)userCredentialsDao.findAll();
	}

	public UserCredentials findByUserName(String userName) {
		return userCredentialsDao.findByUserName(userName);
	}

	@Override
	public UserCredentials update(UserCredentials userCredentials) {
		return userCredentialsDao.update(userCredentials);
	
	}

}
