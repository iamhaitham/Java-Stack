package com.codingdojo.Relationships.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import com.codingdojo.Relationships.models.License;
import com.codingdojo.Relationships.models.Person;
import com.codingdojo.Relationships.services.LicenseService;
import com.codingdojo.Relationships.services.PersonService;

@Controller
public class LicenseControllers {
	private final LicenseService licenseService;
	private final PersonService personService;

	public LicenseControllers(LicenseService licenseService,PersonService personService) {
		this.licenseService=licenseService;
		this.personService=personService;
	}

	@RequestMapping("/licenses/new")
	public String newLicense(@ModelAttribute(value="license") License license,Model model) {
		List<Person> allPersons=personService.allPersons();
		model.addAttribute("persons",allPersons);
		return "newLicense.jsp";
	}
	
	@RequestMapping(value="/licenses/newLicenseProcessing",method=RequestMethod.POST)
	public String newLicenseProcessing(@ModelAttribute(value="license") License license,@RequestParam(value="myOption") Person myOption, @RequestParam(value="myState") String myState,@RequestParam(value="myDate") Date myDate) {
		int myNumber=licenseService.generateLicenseNumber();
		licenseService.createLicense(license, myOption, myState,myDate,myNumber);
		return "redirect:/licenses/new";
	}
	  @InitBinder
	    public void initBinder(WebDataBinder binder, WebRequest request) {
	        //convert the date Note that the conversion here should always be in the same format as the string passed in, e.g. 2015-9-9 should be yyyy-MM-dd
	        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor is a custom date editor
	    }
}
