package com.quiz.webbiskoolsltd.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quiz.webbiskoolsltd.pgdb.Users;
import com.quiz.webbiskoolsltd.repository.IUserDao;

@Service
public class QuizUserDetailsService implements UserDetailsService {
	
	private static final Logger log = LoggerFactory.getLogger(QuizUserDetailsService.class);
	
	@Autowired
	private IUserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
