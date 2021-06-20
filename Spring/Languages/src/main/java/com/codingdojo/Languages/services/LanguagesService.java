package com.codingdojo.Languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.Languages.models.Languages;
import com.codingdojo.Languages.repositories.LanguagesRepository;

@Service
public class LanguagesService {
    private final LanguagesRepository languagesRepository;
    
    public LanguagesService(LanguagesRepository languagesRepository) {
    	this.languagesRepository=languagesRepository;
    }
    
    // returns all the languages
    public List<Languages> allLanguages(){
    	return languagesRepository.findAll();
    }
    
    // creates a language
    public Languages createLanguages(Languages language) {
    	return languagesRepository.save(language);
    }
    
    // retrieves a language
    public Languages findLanguage(Long id) {
    	Optional<Languages> optionalLanguages=languagesRepository.findById(id);
    	if(optionalLanguages.isPresent()) {
    		return optionalLanguages.get();
    	}else {
    		return null;
    	}
    }
    
    //Updates a language
    public Languages updateLanguage(Long id,String name,String creator,String version) {
    	Languages myLanguage=findLanguage(id);
    	myLanguage.setName(name);
    	myLanguage.setCreator(creator);
    	myLanguage.setVersion(version);
    	return languagesRepository.save(myLanguage);
    }
    
    //Deletes a language
    public void deleteLanguage(Long id) {
    	languagesRepository.deleteById(id);
    }

}
