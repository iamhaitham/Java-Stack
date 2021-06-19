package com.axsos.routing;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class GettingFamiliarWithRoutingUsingPathVariables {
	@RequestMapping("/{var}")
	public String dojo(@PathVariable("var") String var) {
		if(var.equals("dojo")) {
			return "The dojo is awesome!";
		}else if(var.equals("burbank-dojo")) {
			return "Burbank Dojo is located in Southern California";
		}else if(var.equals("san-jose")) {
			return "SJ dojo is the headquarters";
		}
		return "This route does not exist yet! Sorry!!";
	}
}
