package com.test.technique.model;

import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Character(
	@JsonProperty("name")
	String name,
	@JsonProperty("height")
	String height,
	@JsonProperty("mass")
	String mass,
	@JsonProperty("films")
	List<String> films,
	@JsonProperty("url")
	String url
) {

	public void getFilmsTitles() {
		RestTemplate restTemplate = new RestTemplate();
		for (int i = 0; i < films.size(); i++) {
			Film filmResponse = restTemplate.getForObject(films.get(i), Film.class);
			films.set(i, filmResponse.title());
		}
	}

	@JsonProperty("id")
	public Integer getId(){
		String[] urlSplit = url.split("/");
		return Integer.parseInt(urlSplit[urlSplit.length - 1]);
	}
}
