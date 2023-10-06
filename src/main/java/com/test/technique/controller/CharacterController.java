package com.test.technique.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.test.technique.model.Character;
import com.test.technique.model.CharacterList;

@RestController
@RequestMapping("/character")
public class CharacterController {
	
	@GetMapping
	public List<Character> getCharacters(){
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://swapi.dev/api/people/";

		CharacterList response = restTemplate.getForObject(url, CharacterList.class);
		List<Character> characters = response.results();

		while(response.next() != null) {
			response = restTemplate.getForObject(response.next(), CharacterList.class);
			characters.addAll(response.results());
		}

		return characters;
	}

	@GetMapping("/{id}")
	public Character getCharacterById(@PathVariable("id") Integer id) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://swapi.dev/api/people/" + id;

		Character response = restTemplate.getForObject(url, Character.class);

		response.getFilmsTitles();

		return response;
	}
}
