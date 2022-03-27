package com.sbapi.sbapidocker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbapi.sbapidocker.client.APIClient;
import com.sbapi.sbapidocker.model.JsonPlaceholderResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HomeService {

	@Autowired
	private APIClient apiClient;
	
	public Mono<JsonPlaceholderResponse> getPlaceholderDataMono(String id) {
		Mono<JsonPlaceholderResponse> response=apiClient.getPlaceholderDataMono(id);
		response.filter(i->i.website.contains(".com"));
		return response;
	}

	public Flux<JsonPlaceholderResponse> getPlaceholderDataFlux() {
		Flux<JsonPlaceholderResponse> response=apiClient.getPlaceholderDataFlux();
		response.filter(i->i.website.contains(".com"));
		return response;
	}
	
	

}
