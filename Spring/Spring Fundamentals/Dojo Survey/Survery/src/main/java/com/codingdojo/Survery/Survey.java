package com.codingdojo.Survery;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Survey {
	
	@RequestMapping(value="/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/resultProcess",method=RequestMethod.POST)
	public String result(Model model,HttpSession session,@RequestParam(value="Name") String Name, @RequestParam(value="Location") String Location, @RequestParam(value="Language") String Language, @RequestParam(value="Comment") String Comment) {
		session.setAttribute("Name", Name);
		session.setAttribute("Location", Location);
		session.setAttribute("Language", Language);
		session.setAttribute("Comment", Comment);
		return "redirect:/result";
	}

	@RequestMapping(value="/result")
	public String resultt(Model model, HttpSession session) {
		model.addAttribute("myName",session.getAttribute("Name"));
		model.addAttribute("myLocation",session.getAttribute("Location"));
		model.addAttribute("myLanguage",session.getAttribute("Language"));
		model.addAttribute("myComment",session.getAttribute("Comment"));
		return "result.jsp";
	}
}
