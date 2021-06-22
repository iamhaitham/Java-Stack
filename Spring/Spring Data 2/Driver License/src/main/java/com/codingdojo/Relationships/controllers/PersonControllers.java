package com.codingdojo.Relationships.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.Relationships.models.Person;
import com.codingdojo.Relationships.services.LicenseService;
import com.codingdojo.Relationships.services.PersonService;

@Controller
public class PersonControllers {
	private final PersonService personService;
	private final LicenseService licenseService;
	public PersonControllers(PersonService personService,LicenseService licenseService) {
		this.personService=personService;
		this.licenseService=licenseService;
	}
	
	Person myPerson;
	
	
	@RequestMapping("/persons/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "newPerson.jsp";
	}
	
	@RequestMapping(value="/persons/newPersonProcessing",method=RequestMethod.POST)
	public String newPersonProcessing(@ModelAttribute("person") Person person,@RequestParam(value="firstname") String firstname,@RequestParam(value="lastname") String lastname) {
		personService.createPerson(person,firstname,lastname);
		return "redirect:/persons/new";
	}
	
	@RequestMapping("/persons/{id}")
	public String profilePage(@PathVariable(value="id")Long id,Model model) {
		Person myPerson=personService.findPerson(id);
		model.addAttribute("person",myPerson);
		return "Profile.jsp";
	}
	
	
}
