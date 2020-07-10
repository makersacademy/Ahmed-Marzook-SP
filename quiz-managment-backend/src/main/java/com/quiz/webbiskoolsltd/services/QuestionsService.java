package com.quiz.webbiskoolsltd.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.webbiskoolsltd.pgdb.Questions;
import com.quiz.webbiskoolsltd.pgdb.Quiz;
import com.quiz.webbiskoolsltd.repository.IQuizDao;

@Service
public class QuestionsService {
	
	@Autowired
	IQuizDao quizDao;
	
	public Set<Questions> getAllQuestionForQuiz(Integer id) {
		return quizDao.findById(id).map(Quiz::getQuestions).orElseThrow(NullPointerException::new);
	}

}
