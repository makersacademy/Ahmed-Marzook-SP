package com.quiz.webbiskoolsltd.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class ApplicationController {
	
	@GetMapping("/process")
	public String process() {
		return "processsing...";
	}

}
