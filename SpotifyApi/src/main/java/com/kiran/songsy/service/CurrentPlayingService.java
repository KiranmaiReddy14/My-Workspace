package com.kiran.songsy.service;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kiran.songsy.exception.NoTrackPlayingException;

@Service
public class CurrentPlayingService {

	private final RestTemplate restTemplate;
	private static final String URL = "https://api.spotify.com/v1/me/player/currently-playing";
	
	@Autowired
	public CurrentPlayingService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public LinkedHashMap getCurrentPlaying(String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + token);

		HttpEntity<String> entity = new HttpEntity<>("paramters", headers);

		ResponseEntity<Object> response = restTemplate.exchange(URL, HttpMethod.GET, entity, Object.class);
		if (response.getStatusCodeValue() == 204) {
			throw new NoTrackPlayingException();
		}
		LinkedHashMap result = (LinkedHashMap) response.getBody();
		return result;
	}

}
