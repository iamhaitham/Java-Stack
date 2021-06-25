package com.codingdojo.DojoOverFlow.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="tags")
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(max=255)
	private String subject;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;

	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tags_questions", 
            joinColumns = @JoinColumn(name = "question_id"), 
            inverseJoinColumns = @JoinColumn(name = "tag_id")
        )
	private List<Question> questions;
	
	//CONSTRUCTOR
	public Tag() {
	}

	// GETTERS
	public Long getId() {
		return id;
	}
	public Tag(String subject) {
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}
	
	public List<Question> getQuestions() {
		return questions;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	// SETTERS
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@PrePersist
	public void setCreatedAt() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	public void setUpdatedAt() {
		this.updatedAt = new Date();
	}
	
	
}
