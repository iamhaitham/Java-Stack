package com.codingdojo.Roster1.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.Roster1.repositories.ContactRepository;
import com.codingdojo.Roster1.repositories.UserRepository;

@Service
public class ApiService {
	private final ContactRepository contactRepository;
	private final UserRepository userRepository;
	public ApiService(ContactRepository contactRepository,UserRepository userRepository) {
		this.contactRepository=contactRepository;
		this.userRepository=userRepository;
	}
	
	//Create a new user
	public void newUser(int age,String firstName,String lastName) {
		userRepository.createUser(age,firstName,lastName);
	}
	
	//Create a new contact
	public void newContact(Long student,String address,String city, String state) {
		contactRepository.createContact(student,address,city,state);
	}
	
	//Print all students and their information
	public List<Object[]> displayInfo(){
		return userRepository.displayInfo();
	}
}
