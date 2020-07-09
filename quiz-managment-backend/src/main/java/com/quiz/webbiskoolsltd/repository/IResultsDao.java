package com.quiz.webbiskoolsltd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.webbiskoolsltd.pgdb.Results;

public interface IResultsDao extends JpaRepository<Results, Integer> {

}
