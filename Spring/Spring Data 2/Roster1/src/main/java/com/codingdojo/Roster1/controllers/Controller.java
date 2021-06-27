package com.codingdojo.Roster1.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.Roster1.models.Contact;
import com.codingdojo.Roster1.services.ApiService;

@RestController
public class Controller {
	private final ApiService apiService;
	public Controller(ApiService apiService) {
		this.apiService=apiService;
	}
	
	//Create a new user
	@RequestMapping("/students/create")
	public void createNewUser(@RequestParam(value="age")int age,@RequestParam(value="firstName")String firstName,@RequestParam(value="lastName")String lastName) {
		apiService.newUser(age,firstName,lastName);
	}
	
	//Create a new contact
	@RequestMapping("/contacts/create")
	public void createNewContact(@RequestParam(value="student")Long student,@RequestParam(value="address")String address,@RequestParam(value="city")String city,@RequestParam(value="state")String state) {
		apiService.newContact(student,address,city,state);
	}
	
	//Print all students and their information
	@RequestMapping("/students")
	public List<Object[]> printInfo(){
		return apiService.displayInfo();
	}
	
}
