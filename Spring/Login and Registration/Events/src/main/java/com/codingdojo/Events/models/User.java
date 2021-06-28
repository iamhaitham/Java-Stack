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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	@NotBlank(message="You can't leave first name field empty!")
	private String firstName;
	@NotBlank(message="You can't leave last name field empty!")
	private String lastName;
	@Email(message="Email must be valid")
	@NotBlank
	private String email;
	@NotBlank(message="You can't leave location field empty!")
	private String location;
	@Size(min=5, message="Password must be greater than 5 characters")
	private String password;	
    @Transient
	private String passwordConfirmation;    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    @OneToMany(mappedBy="hostUser", fetch = FetchType.LAZY)
    private List<Event> hostedEvents;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "users_attend_events", 
        joinColumns = @JoinColumn(name = "attended_user_id"), 
        inverseJoinColumns = @JoinColumn(name = "attended_event_id")
    )
    private List<Event> attendedEvents;
    @OneToMany(mappedBy="commenterUser", fetch = FetchType.LAZY)
    private List<Comment> comments; 

    // ****** CONSTRUCTOR ******    
    public User() {
	}

    // ****** GETTERS ******
	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getLocation() {
		return location;
	}

	public String getPassword() {
		return password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public List<Event> getHostedEvents() {
		return hostedEvents;
	}

	public List<Event> getAttendedEvents() {
		return attendedEvents;
	}

	public List<Comment> getComments() {
		return comments;
	}
	
    // ****** SETTERS ******
    public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public void setHostedEvents(List<Event> hostedEvents) {
		this.hostedEvents = hostedEvents;
	}

	public void setAttendedEvent(List<Event> attendedEvents) {
		this.attendedEvents = attendedEvents;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
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
