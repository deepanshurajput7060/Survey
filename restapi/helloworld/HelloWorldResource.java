package com.dee.springboot.restapi.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// @Controller
@RestController
public class HelloWorldResource {

	@RequestMapping("/hello-world")
	// @ResponseBody 
	// For returning a string value, need to use @ResponseBody for @Controller
	public String helloworld() {
		return "Hello World";
	}
	
}
