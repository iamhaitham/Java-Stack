package com.codingdojo.Events.models;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="events")
public class Event {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String eventName;
	@OneToMany(mappedBy="event", fetch = FetchType.LAZY)
    private List<Comment> comments;
	@NotBlank
	private String location; 
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Future
	private Date eventDate;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="host_user_id")
    private User hostUser;
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "users_attend_events", 
        joinColumns = @JoinColumn(name = "attended_event_id"), 
        inverseJoinColumns = @JoinColumn(name = "attended_user_id")
    )
    private List<User> attendedUsers;
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    // ****** CONSTRUCTOR ******
    public Event() {
	}

    // ****** GETTERS ******
    public Long getId() {
		return id;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public User getHostUser() {
		return hostUser;
	}

	public List<User> getAttendedUsers() {
		return attendedUsers;
	}
	
	public String getEventName() {
		return eventName;
	}

	public String getLocation() {
		return location;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

    // ****** SETTERS ******
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public void setHostUser(User hostUser) {
		this.hostUser = hostUser;
	}

	public void setAttendedUsers(List<User> attendedUsers) {
		this.attendedUsers = attendedUsers;
	}
	
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
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
