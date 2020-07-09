package com.quiz.webbiskoolsltd.pgdb.models;

public class Answer {
	
	private String answerTitle;
	
	private Boolean correct;

	public Answer() {
		super();
	}

	public String getAnswerTitle() {
		return answerTitle;
	}

	public void setAnswerTitle(String answerTitle) {
		this.answerTitle = answerTitle;
	}

	public Boolean getCorrect() {
		return correct;
	}

	public void setCorrect(Boolean correct) {
		this.correct = correct;
	}
	
	

}
