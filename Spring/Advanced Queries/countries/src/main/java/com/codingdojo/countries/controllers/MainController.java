package com.codingdojo.countries.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.countries.models.Country;
import com.codingdojo.countries.services.ApiService;

@RestController
public class MainController {
	@Autowired
	private final ApiService apiService;
	public MainController(ApiService apiService) {
		this.apiService=apiService;
}
	
	@RequestMapping("/q1/{language}")
	public List<Object[]> q1(@PathVariable(value="language")String language) {
		return apiService.CountryByLang(language);
	}
	
	@RequestMapping("/q2")
	public List<Object[]> q2(){
		return apiService.CitiesCount();
	}
	
	@RequestMapping("/q3/{name}")
	public List<Object[]> q3(@PathVariable(value="name")String name){
		return apiService.CitiesByCountryName(name);
	}
	
	@RequestMapping("/q4")
	public List<Object[]> q4(){
		return apiService.LanguagesInEachCountry();
	}
	
	@RequestMapping("/q5/{surface_area}/{population}")
	public List<Object[]> q5(@PathVariable(value="surface_area") double surface_area,@PathVariable(value="population") int population){
		return apiService.CountryByAreaAndPopulation(surface_area,population);
	}
	
	@RequestMapping("/q6")
	public List<Object[]> q6(){
		return apiService.CountryByGovernmentalAndAreaAndLife();
	}
	
	@RequestMapping("/q7")
	public List<Object[]> q7(){
		return apiService.SpecificCitiesInArgentinaBuenosAires();
	}
	
	@RequestMapping("/q8")
	public List<Object[]> q8(){
		return apiService.CountriesAndRegions();
	}
}
