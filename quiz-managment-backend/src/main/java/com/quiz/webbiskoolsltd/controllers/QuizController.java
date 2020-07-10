package com.quiz.webbiskoolsltd.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.webbiskoolsltd.pgdb.Quiz;
import com.quiz.webbiskoolsltd.services.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	public QuizService quizService;
	
	@GetMapping("/allQuiz")
	public List<Quiz> getAllQuiz(Principal auth) {
		System.out.println(auth.getName() + auth.getClass() + auth.toString());
		return quizService.getAllQuiz();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping("/addQuiz")
	public void addQuiz(@RequestBody Quiz quiz,Principal auth) {
		quizService.addQuiz(quiz);
	}

}
