package com.codingdojo.DojoOverFlow.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="answers")
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String answer;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="question_id")
	private Question question;

	//CONSTRUCTOR
	public Answer() {
	}
	
	// GETTERS
	public Long getId() {
		return id;
	}

	public String getAnswer() {
		return answer;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public Question getQuestion() {
		return question;
	}

	// SETTERS
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	@PrePersist
	public void setCreatedAt() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	public void setUpdatedAt() {
		this.updatedAt = new Date();
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
	
}
