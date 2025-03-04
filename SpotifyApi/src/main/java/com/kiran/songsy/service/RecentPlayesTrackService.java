package com.kiran.songsy.service;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RecentPlayesTrackService {

	private final RestTemplate restTemplate;
	private static final String URL = "https://api.spotify.com/v1/me/player/recently-played?limit=50";
	
	@Autowired
	public RecentPlayesTrackService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public Object getHistory(String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + token);
		HttpEntity<String> entity = new HttpEntity<>("paramters", headers);
		ResponseEntity<Object> response = restTemplate.exchange(URL, HttpMethod.GET, entity, Object.class);
		LinkedHashMap result = (LinkedHashMap) response.getBody();
		return result;
	}
}
