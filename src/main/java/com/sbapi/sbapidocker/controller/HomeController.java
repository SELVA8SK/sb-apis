package com.sbapi.sbapidocker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sbapi.sbapidocker.client.APIClient;
import com.sbapi.sbapidocker.model.JsonPlaceholderResponse;
import com.sbapi.sbapidocker.service.HomeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class HomeController {
	
	@Autowired
	private HomeService homeservice;
		
	@GetMapping("/home")
	public String getHome()
	{
		return "Home Called";
	}
	
	
	@GetMapping("/message")
	public String getMessages()
	{
		return "Home Called and method is getMessage";
	}
	
	@GetMapping("/placeholder/{id}")
	public Mono<JsonPlaceholderResponse> getJsonPlaceholder(@PathVariable ("id") String id)
	{
		return homeservice.getPlaceholderDataMono(id);
	}

	@GetMapping("/placeholders")
	public Flux<JsonPlaceholderResponse> getJsonPlaceholderFlux()
	{
		return homeservice.getPlaceholderDataFlux();
	}
}
