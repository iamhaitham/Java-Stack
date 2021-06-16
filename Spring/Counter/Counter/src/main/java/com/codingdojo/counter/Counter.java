package com.codingdojo.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Counter {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/counter")
	public String counter(Model model, HttpSession session) {
		if(session.isNew()) {
			session.setAttribute("count", 0);
			model.addAttribute("myCounter", 0);
		}else {
			Integer myCounter = (Integer) session.getAttribute("count");
			myCounter++;
			session.setAttribute("count", myCounter);
			model.addAttribute("myCounter", myCounter);
			}
		return "counter.jsp";
	}
	@RequestMapping("/counter2")
	public String counterBy2(Model model, HttpSession session2) {
		if(session2.isNew()) {
			session2.setAttribute("count",0);
			model.addAttribute("myCounter2",0);
		}else {
			Integer myCounter2 =(Integer) session2.getAttribute("count");
			myCounter2+=2;
			session2.setAttribute("count", myCounter2);
			model.addAttribute("myCounter2",myCounter2);
		}
		return "counterBy2.jsp";
	}
	@RequestMapping("/destroy")
	public String destroy(Model model) {
		model.addAttribute("myCounter","0");
		return "counter.jsp";
	}
	@RequestMapping("/destroy2")
	public String destroy2(Model model) {
		model.addAttribute("myCounter2","0");
		return "counterBy2.jsp";
	}
}
