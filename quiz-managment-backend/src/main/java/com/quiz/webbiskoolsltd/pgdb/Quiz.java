package com.quiz.webbiskoolsltd.pgdb;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Table(name = "quiz", schema = "public")
@Entity
public class Quiz {
	
	@Id
	@GenericGenerator(name = "sequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = "sequence_name", value = "quiz_seq"), @Parameter(name = "increment_size", value = "1") })
	@GeneratedValue(generator = "sequence")
	@Column(name = "quiz_id", unique = true, nullable = false)
	private Integer quizId;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "quiz")
	private Set<Questions> questions = new HashSet<>();
	
	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "quiz")
	private Set<Results> results = new HashSet<>();

	public Quiz() {
		super();
	}

	public Integer getQuizId() {
		return quizId;
	}

	public void setQuizId(Integer quizId) {
		this.quizId = quizId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Questions> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Questions> questions) {
		this.questions = questions;
	}

	public Set<Results> getResults() {
		return results;
	}

	public void setResults(Set<Results> results) {
		this.results = results;
	}
}
