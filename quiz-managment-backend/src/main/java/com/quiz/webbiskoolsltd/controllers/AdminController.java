package com.quiz.webbiskoolsltd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.webbiskoolsltd.pgdb.Users;
import com.quiz.webbiskoolsltd.repository.IRolesDao;
import com.quiz.webbiskoolsltd.repository.IUserDao;


@RestController
@RequestMapping("/secure/rest")
public class AdminController {
	
	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IRolesDao rolesDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping("/admin/add")
	public String addUserByAdmin(@RequestBody Users user) {
		String pwd = user.getPassword();
		String encryptPwd = passwordEncoder.encode(pwd);
		user.setPassword(encryptPwd);
		userDao.save(user);
		return "User added Succesfully...";
		
	}

}
