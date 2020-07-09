package com.quiz.webbiskoolsltd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.webbiskoolsltd.pgdb.Quiz;
import com.quiz.webbiskoolsltd.repository.IQuizDao;

@Service
public class QuizService {
	
	@Autowired
	private IQuizDao quizDao;
	public List<Quiz> getAllQuiz() {
		return quizDao.findAll();
	}

}
