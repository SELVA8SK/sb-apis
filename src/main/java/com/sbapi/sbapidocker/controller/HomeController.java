package com.sbapi.sbapidocker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
		
	@GetMapping("/home")
	public String getHome()
	{
		return "Home Called";
	}
	
	
	@GetMapping("/message")
	public String getMessage()
	{
		return "Home Called and method is getMessage";
	}

}
