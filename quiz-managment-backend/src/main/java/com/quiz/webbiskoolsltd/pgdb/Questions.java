package com.quiz.webbiskoolsltd.pgdb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.quiz.webbiskoolsltd.pgdb.models.AnswerObject;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

@Table(name = "questions", schema = "public")
@Entity
@TypeDefs({
    @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class Questions {
	
	@Id
	@GenericGenerator(name = "sequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = "sequence_name", value = "question_seq"), @Parameter(name = "increment_size", value = "1") })
	@GeneratedValue(generator = "sequence")
	@Column(name = "question_id", unique = true, nullable = false)
	private Integer questionId;
	
	@Column(name = "question_title", nullable = false)
	private String questionTitle;
	
	@Type(type ="jsonb")
	@Column(name = "answers")
	private AnswerObject answers;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "quiz_id")
	private Quiz quiz;

	public Questions() {
		super();
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public AnswerObject getAnswers() {
		return answers;
	}

	public void setAnswers(AnswerObject answers) {
		this.answers = answers;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

}
