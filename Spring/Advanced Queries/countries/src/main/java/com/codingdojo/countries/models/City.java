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
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Entity
@Table(name="cities")
public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(max=35)
	private String name;
	
	@Size(max=3)
	private String country_code;
	
	@Size(max=20)
	private String district;
	
	@Max(11)
	private int population;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="country_id")
    private Country country;

	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
	
	// **** CONSTRUCTOR ****
	public City() {
	}

	// **** GETTERS ****
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCountry_code() {
		return country_code;
	}

	public String getDistrict() {
		return district;
	}

	public int getPopulation() {
		return population;
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

	public void setName(String name) {
		this.name = name;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public void setPopulation(int population) {
		this.population = population;
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
