package com.codingdojo.Languages.controllers;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.Languages.models.Languages;
import com.codingdojo.Languages.services.LanguagesService;

@Controller
public class LanguagesController {
	private final LanguagesService languagesService;
	
	
	public LanguagesController(LanguagesService languagesService) {
		this.languagesService=languagesService;
	}

	@RequestMapping(value="/languages", method=RequestMethod.GET)
	public String index(Model model, @ModelAttribute("language") Languages language) {
		model.addAttribute("languages",languagesService.allLanguages());
		return "Languages.jsp";
	}
	
	@RequestMapping(value="/languages",method=RequestMethod.POST)
	public String createNewLanguage(Model model,@Valid @ModelAttribute("language") Languages language, BindingResult result) {
		 if (result.hasErrors()) {
				model.addAttribute("language", language);
	            return "Languages.jsp";
	        } else {
	            languagesService.createLanguages(language);
	            return "redirect:/languages";
	        }
	}
	
	@RequestMapping(value="/languages/{id}",method=RequestMethod.GET)
	public String showLanguageInfo(Model model,@PathVariable(value="id") Long id) {
		Languages myLanguage=languagesService.findLanguage(id);
		model.addAttribute("language",myLanguage);
		return "Info.jsp";
	}
	
	@RequestMapping(value="/languages/{id}/edit",method=RequestMethod.GET)
	public String editLanguages(Model model,@PathVariable(value="id") Long id) {
		Languages myLanguage=languagesService.findLanguage(id);
		model.addAttribute("language",myLanguage);
		return "Edit.jsp";
	}
	
	@RequestMapping(value="/languages/{id}",method=RequestMethod.PUT)
	public String updateLanguage(@Valid @ModelAttribute("language") Languages language,BindingResult result,@PathVariable("id") Long id,@RequestParam(value="name") String name,@RequestParam(value="creator") String creator,@RequestParam(value="version") String version) {
		if (result.hasErrors()) {
	            return "redirect:/languages/{id}/edit";
	        } else {
	        	languagesService.updateLanguage(id,name,creator,version);
	            return "redirect:/languages";
	        }
	}
	
	@RequestMapping(value="/languages/{id}/delete")
	public String deleteLanguage(@PathVariable(value="id")Long id) {
		languagesService.deleteLanguage(id);
		return "redirect:/languages";
	}
}
