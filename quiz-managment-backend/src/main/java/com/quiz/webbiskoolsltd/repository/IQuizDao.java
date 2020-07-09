package com.quiz.webbiskoolsltd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.webbiskoolsltd.pgdb.Quiz;

public interface IQuizDao extends JpaRepository<Quiz, Integer> {

}
