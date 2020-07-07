package com.quiz.webbiskoolsltd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.webbiskoolsltd.pgdb.Users;

@Repository
public interface IUserDao extends JpaRepository<Users, Integer> {
	Users findByFirstName(String firstName);
	Users findByEmail(String email);
}
