package com.oracle.test.entity;

import javax.persistence.*;

@Entity
@NamedQueries({
	@NamedQuery(name = "Answer.findAll", query = "SELECT a FROM Answer a"),
})
public class Answer extends BaseEntity {
	
	@Column(nullable = false, length = 10000)
	private String text;
	
	@Column(length = 10000)
	private String comment;
	
	@Column(nullable = false)
	private boolean correct = false;
	
	@Column(nullable = false)
	private boolean isTextInHtml = false;
	
	@ManyToOne
	private Question question;

	public String getText() {
		return text;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
	

	public void setText(String text) {
		this.text = text;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	public boolean isIsTextInHtml() {
		return isTextInHtml;
	}

	public void setIsTextInHtml(boolean isTextInHtml) {
		this.isTextInHtml = isTextInHtml;
	}	
}

