package com.TinyURL.url.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TinyURL.url.entity.URL;
import com.TinyURL.url.service.TrimURL;

@RestController
@CrossOrigin
public class URLController {
	@Autowired
	private TrimURL code;
	
	@PostMapping("/")
	public String shortURL(@RequestBody URL url) {
		return code.encode(url.getUrl());
	}
	@GetMapping("/{url}")
	public String FullURL(@PathVariable("url") String url) {
		return code.decode(url);
	}
}
