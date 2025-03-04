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
public class FeaturedPlaylistService {

	private final RestTemplate restTemplate;
	private static final String URL = "https://api.spotify.com/v1/browse/featured-playlists?limit=50";

	@Autowired
	public FeaturedPlaylistService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public Object getPlaylists(String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + token);

		HttpEntity<String> entity = new HttpEntity<>("paramters", headers);

		ResponseEntity<Object> response = restTemplate.exchange(URL, HttpMethod.GET, entity, Object.class);
		LinkedHashMap result = (LinkedHashMap) response.getBody();

		return result;
	}
}
