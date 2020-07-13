package com.quiz.webbiskoolsltd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.webbiskoolsltd.pgdb.Questions;

public interface IQuestionDao extends JpaRepository<Questions, Integer> {

}
