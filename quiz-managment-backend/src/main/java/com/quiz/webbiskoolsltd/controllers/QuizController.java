package com.quiz.webbiskoolsltd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	public List<Quiz> getAllQuiz() {
		return quizService.getAllQuiz();
	}

}
