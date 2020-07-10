package com.quiz.webbiskoolsltd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.webbiskoolsltd.pgdb.Users;
import com.quiz.webbiskoolsltd.pgdb.models.QuizUser;
import com.quiz.webbiskoolsltd.repository.IUserDao;
import com.quiz.webbiskoolsltd.services.util.AuthRequest;
import com.quiz.webbiskoolsltd.services.util.JwtUtil;

@RestController
public class ApplicationController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private IUserDao userDao;

	@GetMapping("/")
	public String process() {
		return "processsing...";
	}

	@PostMapping("/authenticate")
	public QuizUser genrateToken(@RequestBody AuthRequest authRequest) throws Exception {
		QuizUser quizUser = new QuizUser();
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken;
		try {
			usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword());
		authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		quizUser.setAuthority(usernamePasswordAuthenticationToken.getAuthorities().toString());
		} catch(Exception ex) {
			throw new UsernameNotFoundException("Invalid Email /password");
		}
		Users user = userDao.findByEmail(authRequest.getEmail());
		quizUser.setAuthority(user.getAuthority());
		quizUser.setFirstName(user.getFirstName());
		quizUser.setLastName(user.getLastName());
		quizUser.setUserId(user.getUserId());
		quizUser.setEmail(authRequest.getEmail());
		quizUser.setToken(jwtUtil.generateToken(authRequest.getEmail()));
		return quizUser;
	}

}
