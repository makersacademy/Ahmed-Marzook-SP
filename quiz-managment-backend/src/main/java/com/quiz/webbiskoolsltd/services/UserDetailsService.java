package com.quiz.webbiskoolsltd.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quiz.webbiskoolsltd.pgdb.Users;
import com.quiz.webbiskoolsltd.repository.IUserDao;

@Service
public class UserDetailsService {
	
	private static final Logger log = LoggerFactory.getLogger(UserDetailsService.class);
	
	@Autowired
	private IUserDao userDao;
	
	@Transactional(readOnly = true)
	public Users loadUserByEmail(String email) {
        Users user = userDao.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        
        log.info("Loading user by email : {}", email);
        return user;
    }

}
