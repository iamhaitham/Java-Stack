package com.axsos.strings;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Routing {
	@RequestMapping("/")
	public String root() {
		return "Hello client! How are you doing?";
	}
	@RequestMapping("/random")
	public String random() {
		return "Spring Boot is great! So easy to just respond with strings";
	}
}
