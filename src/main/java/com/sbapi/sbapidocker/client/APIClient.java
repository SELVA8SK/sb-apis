package com.sbapi.sbapidocker.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.sbapi.sbapidocker.model.JsonPlaceholderResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class APIClient {

	@Value("${placeholder.url}")
	private String baseUrl;

	WebClient webClient = WebClient.create();

	public Mono<JsonPlaceholderResponse> getPlaceholderDataMono(String id) {
		Mono<JsonPlaceholderResponse> response = webClient.get().uri(baseUrl + "/users/" + id)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).retrieve()
				.bodyToMono(JsonPlaceholderResponse.class);

		return response;
	}

	public Flux<JsonPlaceholderResponse> getPlaceholderDataFlux() {
		Flux<JsonPlaceholderResponse> response = webClient.get().uri(baseUrl + "/users")
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).retrieve()
				.bodyToFlux(JsonPlaceholderResponse.class);
		return response;
	}

}
