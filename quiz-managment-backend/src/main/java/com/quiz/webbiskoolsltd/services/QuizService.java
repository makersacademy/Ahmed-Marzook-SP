package com.quiz.webbiskoolsltd.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.quiz.webbiskoolsltd.pgdb.Quiz;
import com.quiz.webbiskoolsltd.repository.IQuizDao;

@Service
public class QuizService {
	
	@Autowired
	private IQuizDao quizDao;
	
	public List<Quiz> getAllQuiz() {
		return quizDao.findAll();
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void addQuiz(Quiz quiz) {
		if(quiz != null) {
			quizDao.save(quiz);
		}
	}
	
	public void deleteQuiz(Integer id) {
		quizDao.deleteById(id);
	}

}
