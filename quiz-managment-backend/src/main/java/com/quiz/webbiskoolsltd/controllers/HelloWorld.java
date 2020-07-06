package com.quiz.webbiskoolsltd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.webbiskoolsltd.pgdb.Users;
import com.quiz.webbiskoolsltd.repository.IUserDao;

@RestController
public class HelloWorld {
	
	@Autowired
	IUserDao repo;
	
	@GetMapping("/message")
    public List<Users> getMessage(){
		List<Users> userList = repo.findAll();
		System.out.println(userList.size());
        return userList;
    }
	
}
