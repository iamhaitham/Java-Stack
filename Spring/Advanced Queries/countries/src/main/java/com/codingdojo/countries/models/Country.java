package com.codingdojo.countries.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Entity
@Table(name="countries")
public class Country {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(max=3)
	private String code;
	
	@Size(max=52)
	private String name;
	
	@Size(max=52)
	private String continent;
	
	@Size(max=26)
	private String region;
	
	@Digits(integer=10, fraction=2)
	private double surface_area;
	
	@Max(6)
	private short indep_year;
	
	@Max(11)
	private int population;
	
	@Digits(integer=3, fraction=1)
	private double life_expectancy;

	@Digits(integer=10, fraction=2)
	private double gnp;

	@Digits(integer=10, fraction=2)
	private double gnp_old;

	@Size(max=45)
	private String local_name;

	@Size(max=45)
	private String government_form;
	
	@Size(max=60)
	private String head_of_state;

	@Max(11)
	private int capital;

	@Size(max=2)
	private String code2;

	@OneToMany(mappedBy="country", fetch = FetchType.LAZY)
    private List<Language> languages;

	@OneToMany(mappedBy="country", fetch = FetchType.LAZY)
    private List<City> cities;
	
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;

	// **** CONSTRUCTOR ****
	public Country() {
	}

	// **** GETTERS ****
	public Long getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public String getContinent() {
		return continent;
	}

	public String getRegion() {
		return region;
	}

	public double getSurface_area() {
		return surface_area;
	}

	public short getIndep_year() {
		return indep_year;
	}

	public int getPopulation() {
		return population;
	}

	public double getLife_expectancy() {
		return life_expectancy;
	}

	public double getGnp() {
		return gnp;
	}

	public double getGnp_old() {
		return gnp_old;
	}

	public String getLocal_name() {
		return local_name;
	}

	public String getGovernment_form() {
		return government_form;
	}

	public String getHead_of_state() {
		return head_of_state;
	}

	public int getCapital() {
		return capital;
	}

	public String getCode2() {
		return code2;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public List<City> getCity() {
		return cities;
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

	public void setCode(String code) {
		this.code = code;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public void setSurface_area(double surface_area) {
		this.surface_area = surface_area;
	}

	public void setIndep_year(short indep_year) {
		this.indep_year = indep_year;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public void setLife_expectancy(double life_expectancy) {
		this.life_expectancy = life_expectancy;
	}

	public void setGnp(double gnp) {
		this.gnp = gnp;
	}

	public void setGnp_old(double gnp_old) {
		this.gnp_old = gnp_old;
	}

	public void setLocal_name(String local_name) {
		this.local_name = local_name;
	}

	public void setGovernment_form(String government_form) {
		this.government_form = government_form;
	}

	public void setHead_of_state(String head_of_state) {
		this.head_of_state = head_of_state;
	}

	public void setCapital(int capital) {
		this.capital = capital;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public void setCity(List<City> city) {
		this.cities = city;
	}

	public void setCreatedAt() {
		this.createdAt = new Date();
	}

	public void setUpdatedAt() {
		this.updatedAt = new Date();
	}


	
}
