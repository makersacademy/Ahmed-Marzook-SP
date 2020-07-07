package com.quiz.webbiskoolsltd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.webbiskoolsltd.pgdb.Role;

public interface IRolesDao extends JpaRepository<Role, Integer>  {

}
