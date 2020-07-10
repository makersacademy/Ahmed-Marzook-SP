package com.quiz.webbiskoolsltd.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.webbiskoolsltd.pgdb.Questions;
import com.quiz.webbiskoolsltd.services.QuestionsService;

@RestController
@RequestMapping("/questions")
public class QuestionController {
	
	@Autowired
	QuestionsService questionsService;
	
	
	@GetMapping()
	@ResponseBody
	public Set<Questions> getQuestionsForQuiz(@RequestParam Integer id) {
		return questionsService.getAllQuestionForQuiz(id);
	}
}
