package com.codingdojo.OneToMany.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.OneToMany.models.Dojo;
import com.codingdojo.OneToMany.models.Ninja;
import com.codingdojo.OneToMany.services.DojoService;
import com.codingdojo.OneToMany.services.NinjaService;

@Controller
public class NinjaController {
	private final NinjaService ninjaService;
	private final DojoService dojoService;
	public NinjaController(NinjaService ninjaService,DojoService dojoService) {
		this.ninjaService=ninjaService;
		this.dojoService=dojoService;
	}
	
	@RequestMapping(value="/ninjas/new")
	public String ninjaNew(@ModelAttribute(value="ninja") Ninja ninja,Model model) {
		List<Dojo> allDojos=dojoService.allDojos();
		model.addAttribute("dojos",allDojos);
		return "ninjaNew.jsp";
	}
	
	@RequestMapping(value="/ninjas/newProcessing",method=RequestMethod.POST)
	public String ninjaNewProcessing(@ModelAttribute(value="ninja")Ninja ninja) {
		ninjaService.createNinja(ninja);
		return "redirect:/ninjas/new";
	}
}
