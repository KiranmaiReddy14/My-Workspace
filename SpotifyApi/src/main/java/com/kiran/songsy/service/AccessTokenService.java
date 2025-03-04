package com.kiran.songsy.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kiran.songsy.dto.AccessTokenDto;
import com.kiran.songsy.properties.SpotifyAppConfigurationProperties;

@Service
@EnableConfigurationProperties(value = SpotifyAppConfigurationProperties.class)
public class AccessTokenService {

	private final SpotifyUrlService spotifyUrlService;
	private final RestTemplate restTemplate;
	private final SpotifyAppConfigurationProperties spotifyAppConfigurationProperties;
	private static final String URL = "https://accounts.spotify.com/api/token";
	private final HttpSession session;

	@Autowired
	public AccessTokenService(SpotifyUrlService spotifyUrlService, RestTemplate restTemplate,
			SpotifyAppConfigurationProperties spotifyAppConfigurationProperties,
			HttpSession session) {
		this.spotifyUrlService = spotifyUrlService;
		this.restTemplate = restTemplate;
		this.spotifyAppConfigurationProperties = spotifyAppConfigurationProperties;
		this.session=session;
	}

	public String getToken(String code) throws JsonMappingException, JsonProcessingException {
		final var properties = spotifyAppConfigurationProperties.getApp();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		String codeVerifier = (String) session.getAttribute("codeVerifier");
	    if (codeVerifier == null) {
	        throw new IllegalStateException("code_verifier is missing. Ensure it was generated before authorization.");
	    }

		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("client_id", properties.getClientId());
		map.add("grant_type", "authorization_code");
		map.add("code", code);
		map.add("redirect_uri", properties.getRedirectUrl());
		map.add("code_verifier", codeVerifier);
	
		
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

	    ResponseEntity<String> response = restTemplate.postForEntity(URL, request, String.class);

	    System.out.println("Spotify Response: " + response.getBody());

	    ObjectMapper objectMapper = new ObjectMapper();
	    AccessTokenDto accessTokenDto = objectMapper.readValue(response.getBody(), AccessTokenDto.class);

	    return accessTokenDto.getAccess_token();
	}

}
