package com.codingdojo.countries.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

@Entity
@Table(name="languages")
public class Language {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(max=3)
	private String country_code;
	
	@Size(max=30)
	private String language;
	
	@Size(max=1)
	private String is_offical;
	
	@Digits(integer=4, fraction=1)
	private double percentage;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="country_id")
    private Country country;

	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
	
	// **** CONSTRUCTOR ****
	public Language() {
	}

	// **** GETTERS ****
	public Long getId() {
		return id;
	}

	public String getCountry_code() {
		return country_code;
	}

	public String getLanguage() {
		return language;
	}

	public String getIs_offical() {
		return is_offical;
	}

	public double getPercentage() {
		return percentage;
	}

	public Country getCountry() {
		return country;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	// **** SETTERS ****
	public void setId(Long id) {
		this.id = id;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setIs_offical(String is_offical) {
		this.is_offical = is_offical;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public void setCreatedAt() {
		this.createdAt = new Date();
	}

	public void setUpdatedAt() {
		this.updatedAt = new Date();
	}

}
