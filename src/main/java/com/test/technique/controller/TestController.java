package com.test.technique.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/test")
public class TestController {
	
	@GetMapping
	public Map<String, String> test() {
		Map<String, String> map = new HashMap<>();
		map.put("value", "hello world");
		return map;
	}
}
