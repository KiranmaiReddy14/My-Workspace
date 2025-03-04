package com.kiran.songsy.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.kiran.songsy.constant.ApiPath;
import com.kiran.songsy.constant.Template;
import com.kiran.songsy.exception.NoTrackPlayingException;
import com.kiran.songsy.service.AccessTokenService;
import com.kiran.songsy.service.CurrentPlayingService;
import com.kiran.songsy.service.ProfileDetailService;
import com.kiran.songsy.service.SpotifyUrlService;

@Controller
public class CallbackController {

	private final SpotifyUrlService spotifyUrlService;
	private final AccessTokenService accessToken;
	private final ProfileDetailService userDetails;
	private final CurrentPlayingService currentPlaying;

	@Autowired
	public CallbackController(SpotifyUrlService spotifyUrlService, AccessTokenService accessToken,
			ProfileDetailService userDetails, CurrentPlayingService currentPlaying) {
		super();
		this.spotifyUrlService = spotifyUrlService;
		this.accessToken = accessToken;
		this.userDetails = userDetails;
		this.currentPlaying = currentPlaying;
	}

	@GetMapping(value = ApiPath.CALLBACK, produces = MediaType.TEXT_HTML_VALUE)
	public String handleCallback(@RequestParam(value = "code", required = false) final String code,
			@RequestParam(value = "error", required = false) final String error, final Model model,
			final HttpSession session) throws JsonMappingException, JsonProcessingException {

		if (error != null) {
			model.addAttribute("url", spotifyUrlService.getAuthorizationURL());
			return Template.CALLBACK_FAILURE;
		}
		session.setAttribute("code", code);
		String token = accessToken.getToken(code);

		session.setAttribute("accessToken", token);
		model.addAttribute("accessToken", token);
		model.addAttribute("userName", userDetails.getUsername(token));

		try {
			model.addAttribute("currentPlaying", currentPlaying.getCurrentPlaying(token));
			model.addAttribute("display", 1);
		} catch (NoTrackPlayingException exception) {
			model.addAttribute("display", 0);
		}

		return Template.CALLBACK_SUCCESS;
	}
}
