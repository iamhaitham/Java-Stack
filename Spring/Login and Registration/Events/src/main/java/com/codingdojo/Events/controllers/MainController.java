package com.codingdojo.Events.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.Events.models.Event;
import com.codingdojo.Events.models.User;
import com.codingdojo.Events.services.EventService;
import com.codingdojo.Events.services.UserService;
import com.codingdojo.Events.validator.UserValidator;

@Controller
public class MainController {
	private final UserService userService;
	private final UserValidator userValidator;
	private final EventService eventService;
	public MainController(UserService userService, UserValidator userValidator, EventService eventService) {
		this.userService = userService;
		this.userValidator = userValidator;
		this.eventService=eventService;
	}

	@RequestMapping("/login")
	public String login(@ModelAttribute(value="user") User user) {
		return "login.jsp";
	}
	
	@RequestMapping(value="/loginProcess",method=RequestMethod.POST)
	public String loginProcess(@Valid @ModelAttribute(value="user") User user,BindingResult result,HttpSession session,RedirectAttributes redirectAttributes) {
		boolean isLogged=userService.authenticateUser(user.getEmail(),user.getPassword());
		if(isLogged==false) {
			redirectAttributes.addFlashAttribute("error","Login information didn't match our records! Please, double-check it again.");		
			return "redirect:/login";
        }else {
        	User myUser=userService.findByEmail(user.getEmail()); //This line is added to avoid an error where the session will not save the userid directly
        	session.setAttribute("user_id",myUser.getId()); 
        	return "redirect:/events";
        }
	}
	
	@RequestMapping(value="/register")
	public String register(@ModelAttribute(value="user") User user) {
		return "register.jsp";
	}
	
	@RequestMapping(value="/registerProcess",method=RequestMethod.POST)
	public String registerProcess(@Valid @ModelAttribute(value="user") User user,BindingResult result,HttpSession session) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "register.jsp";
		}else {
			User newUser=userService.registerUser(user);
			session.setAttribute("user_id", newUser.getId());
			return "redirect:/events";
		}
	}
	
	@RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
	 
	@RequestMapping("/events")
	public String events(Model model,HttpSession session, @ModelAttribute(value="event") Event event) {
		Long userId=(Long) session.getAttribute("user_id");
		User myUser=userService.findUserById(userId);
		model.addAttribute("myUser",myUser.getFirstName()+" "+myUser.getLastName());
		List<Event> allEventsInSameLocation=eventService.findEventsByLocation(myUser.getLocation());
		model.addAttribute("allEventsInSameLocation",allEventsInSameLocation);
		List<Event> allEventsInOtherLocation=eventService.findEventsByOtherLocations(myUser.getLocation());
		model.addAttribute("allEventsInOtherLocation",allEventsInOtherLocation);
		model.addAttribute("myUserId",userId);
		return "events.jsp";
	}
	
	@RequestMapping(value="/createEvent",method=RequestMethod.POST)
	public String createEvent(@Valid @ModelAttribute(value="event") Event event,BindingResult result,HttpSession session,RedirectAttributes redirectAttributes,Model model) {
		if(result.hasErrors()) {
			redirectAttributes.addFlashAttribute("dateError","Only future dates allowed!");
			return "redirect:/events";
		}else {
			Event myEvent=eventService.createEvent(event);
			Long userId=(Long)session.getAttribute("user_id");
			User myUser=userService.findUserById(userId);
			myEvent.setHostUser(myUser);
			eventService.updateEvent(myEvent);
			return "redirect:/events";		
		}
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.POST)
	public String deleteEvent(@PathVariable(value="id")Long id) {
		eventService.deleteEvent(id);
		return "redirect:/events";
	}
	
	
	@RequestMapping("/events/{id}/edit")
	public String edit(@PathVariable(value="id")Long id,@ModelAttribute(value="event") Event event,Model model,HttpSession session) {
		Event myEvent=eventService.findEventById(id);
		if(session.getAttribute("user_id").equals(myEvent.getHostUser().getId())) {
		model.addAttribute("myEvent",myEvent);
		return "edit.jsp";
		}else {
			return "redirect:/events";
		}
	}
	
	@RequestMapping(value="/events/{id}/editProcess",method=RequestMethod.POST)
	public String editProcess(@PathVariable(value="id")Long id,@Valid @ModelAttribute(value="event") Event event,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}else {
			Event myEvent=eventService.findEventById(id);
			eventService.editEvent(myEvent.getEventName(),myEvent.getLocation(),myEvent.getEventDate(),id);
		return "redirect:/events/"+id+"/edit";
		}
	}
	
}
