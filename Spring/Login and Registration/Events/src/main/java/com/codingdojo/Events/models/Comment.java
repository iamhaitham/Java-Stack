package com.codingdojo.Events.models;

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
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="comments")
public class Comment {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	@NotBlank(message="You can't add an empty comment!")
	private String comment;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="commenter_user_id")
    private User commenterUser;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="event_id")
    private Event event;
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    
    // ****** CONSTRUCTOR ******
	public Comment() {
	}

    // ****** GETTERS ******
	public Long getId() {
		return id;
	}

	public String getComment() {
		return comment;
	}

	public User getCommenterUser() {
		return commenterUser;
	}

	public Event getEvent() {
		return event;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	// ****** SETTERS ******
	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setCommenterUser(User commenterUser) {
		this.commenterUser = commenterUser;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
	
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }

	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
