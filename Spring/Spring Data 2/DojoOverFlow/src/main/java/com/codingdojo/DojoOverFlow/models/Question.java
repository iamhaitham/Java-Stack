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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="questions")
public class Question {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Question may not be empty")
	private String question;
	
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
    
    @OneToMany(mappedBy="question", fetch = FetchType.LAZY)
    private List<Answer> answers;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tags_questions", 
            joinColumns = @JoinColumn(name = "tag_id"), 
            inverseJoinColumns = @JoinColumn(name = "question_id")
        )
    private List<Tag> tags;

    @Transient
    @Pattern(regexp="^(([a-zA-Z\\\\s])+$|([a-zA-Z\\\\s]+,)[a-zA-Z\\\\s]+){1,2}$",message="Tags must be separated by commas, max 3")
    private String tagsAsString;
    
    public String[] splitTags() {
		return this.tagsAsString.split("\\s*,\\s*");
	}
    
    // CONSTRUCTOR
	public Question() {
	}
	
	public Question(String question, List<Tag> tags) {
		this.question = question;
		this.tags = tags;
	}
    
	// GETTERS
	public Long getId() {
		return id;
	}

	public String getQuestion() {
		return question;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public List<Tag> getTags() {
		return tags;
	}
	
	public String getTagsAsString() {
		return tagsAsString;
	}

	// SETTERS
	public void setQuestion(String question) {
		this.question = question;
	}

    public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	@PrePersist
	public void setCreatedAt() {
		this.createdAt = new Date();
	}
    
    @PreUpdate
	public void setUpdatedAt() {
		this.updatedAt = new Date();
	}

	public void setTagsAsString(String tagsAsString) {
		this.tagsAsString = tagsAsString;
	}   
 
    
}
