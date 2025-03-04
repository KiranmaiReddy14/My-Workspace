package com.kiran.songsy.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import com.kiran.songsy.properties.SpotifyAppConfigurationProperties;
import com.kiran.songsy.utility.CodeChallengeUtility;
import com.kiran.songsy.utility.CodeVerifierUtility;

import lombok.Data;

@Data
@Service
@EnableConfigurationProperties(SpotifyAppConfigurationProperties.class)
public class SpotifyUrlService {

	private final SpotifyAppConfigurationProperties spotifyAppConfigurationProperties;
	private final HttpSession session;

	@Autowired
	public SpotifyUrlService(SpotifyAppConfigurationProperties spotifyAppConfigurationProperties, HttpSession session) {
		this.spotifyAppConfigurationProperties = spotifyAppConfigurationProperties;
		this.session = session;
	}

	public String getAuthorizationURL() {
		final var properties = spotifyAppConfigurationProperties.getApp();
		final var codeVerifier = CodeVerifierUtility.generate();
		session.setAttribute("codeVerifier", codeVerifier);
		return "https://accounts.spotify.com/en/authorize?client_id=" + properties.getClientId()
				+ "&response_type=code&redirect_uri=" + properties.getRedirectUrl()
				+ "&code_challenge_method=S256&code_challenge=" + CodeChallengeUtility.generate(codeVerifier)
				+ "&scope=ugc-image-upload,user-read-playback-state,user-modify-playback-state,user-read-currently-playing,streaming,app-remote-control,user-read-email,user-read-private"
				+ ",playlist-read-collaborative,playlist-modify-public,playlist-read-private,playlist-modify-private,user-library-modify,user-library-read,user-top-read,user-read-playback-position,user-read-recently-played,user-follow-read,user-follow-modify";
	}

	public String getCodeVerifier() {
		return (String) session.getAttribute("codeVerifier");
	}
}
