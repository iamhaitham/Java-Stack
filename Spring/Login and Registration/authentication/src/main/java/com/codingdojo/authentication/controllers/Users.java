package com.codingdojo.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.authentication.models.User;
import com.codingdojo.authentication.services.UserService;
import com.codingdojo.authentication.validator.UserValidator;

@Controller
public class Users {
    private final UserService userService;
    private final UserValidator userValidator;
    public Users(UserService userService,UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
    
    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    @RequestMapping("/login")
    public String login() {
        return "loginPage.jsp";
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
    	// if result has errors, return the registration page (don't worry about validations just now)
        // else, save the user in the database, save the user id in session, and redirect them to the /home route
    	userValidator.validate(user, result);
    	if(result.hasErrors()) {
    		return "registrationPage.jsp";
    	}else {
    		User newUser=userService.registerUser(user);
    		session.setAttribute("user_id",newUser.getId());
    		return "redirect:/home";
    	}
    	
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session,RedirectAttributes redirectAttributes) {
        // if the user is authenticated, save their user id in session
        // else, add error messages and return the login page
    	boolean authentication_result=userService.authenticateUser(email,password);
    	if(authentication_result==false) {
    		redirectAttributes.addFlashAttribute("error","Login information didn't match our records! Please, double-check it again.");
    		return "redirect:/login";
    	}else {
    		session.setAttribute("user_id",userService.findByEmail(email).getId());
    		return "redirect:/home";
    	}
    }
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        // get user from session, save them in the model and return the home page
    	if(session.getAttribute("user_id")==null){
    		return "You didn't register or log in!";
    	}else {
    	Long myUserId=(Long) session.getAttribute("user_id");
    	User myUser=userService.findUserById(myUserId);
    	model.addAttribute("user",myUser);
    	return "homePage.jsp";
    	}
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session
        // redirect to login page
        session.invalidate();
        return "redirect:/login";
    }
}