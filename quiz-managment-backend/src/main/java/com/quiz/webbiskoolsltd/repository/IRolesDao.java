package com.quiz.webbiskoolsltd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.webbiskoolsltd.pgdb.Authority;

public interface IRolesDao extends JpaRepository<Authority, Integer>  {

}
