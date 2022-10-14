package com.TinyURL.url.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TrimURL {
	private Map<String, String> map = new HashMap<>();
	@Value("${URL:localhost:8081/}")
	private String BASE_URL ;
	
	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		this.map.put(String.valueOf(longUrl.hashCode()), longUrl);
		log.info(""+this.map);
		return BASE_URL+String.valueOf(longUrl.hashCode());
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		return this.map.getOrDefault(shortUrl,"Incorrect URL");
	}
}
