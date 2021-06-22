package com.codingdojo.OneToMany.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.OneToMany.models.Dojo;
import com.codingdojo.OneToMany.services.DojoService;

@Controller
public class DojoController {
	private final DojoService dojoService;
	public DojoController(DojoService dojoService) {
		this.dojoService=dojoService;
	}
	
	@RequestMapping(value="/dojos/new")
	public String dojoNew(@ModelAttribute(value="dojo") Dojo dojo,Model model) {
		return "dojoNew.jsp";
	}
	
	@RequestMapping(value="/dojos/newProcessing",method=RequestMethod.POST)
	public String dojoNewProcessing(@ModelAttribute(value="dojo") Dojo dojo,Model model,@RequestParam("dojoName") String dojoName) {
		dojoService.createDojo(dojo,dojoName);
		return "redirect:/dojos/new";
	}
	
	@RequestMapping("/dojos/{id}")
	public String dojoInfo(@PathVariable(value="id") Long id,Model model) {
		Dojo dojoById=dojoService.findDojo(id);
		model.addAttribute("dojo",dojoById);
		return "dojoInfo.jsp";
	}
}
