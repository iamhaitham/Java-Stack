package com.codingdojo.Relationships.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.Relationships.models.License;
import com.codingdojo.Relationships.models.Person;
import com.codingdojo.Relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	private final LicenseRepository licenseRepository;
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository=licenseRepository;
	}
	
	public List<License> allLicenses(){
		return licenseRepository.findAll();
	}
	
	public License createLicense(License license, Person myOption, String myState ,Date myDate,int myNumber) {
		license.setPerson(myOption);
		license.setState(myState);
		license.setExpirationDate(myDate);
		license.setNumber(myNumber);
		return licenseRepository.save(license);
	}
	public int generateLicenseNumber() {
		License license = licenseRepository.findTopByOrderByNumberDesc();
		if(license == null)
			return 1;
		int largestNumber = license.getNumber();
		largestNumber++;
		return (largestNumber);
	}
}
