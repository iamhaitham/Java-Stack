package com.codingdojo.HelloHuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
	@RequestMapping("/")
	public String query(@RequestParam(value="q",required=false) String firstName,@RequestParam(value="qq",required=false) String lastName) {
		if(firstName.isEmpty() && lastName.isEmpty()) {
		return "Hello Human";
	}else {
		return "<h1>Hello "+firstName+" "+lastName+"</h1>";
		}
	}	
}
