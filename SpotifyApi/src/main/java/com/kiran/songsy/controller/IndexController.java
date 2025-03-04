package com.kiran.songsy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kiran.songsy.constant.Template;
import com.kiran.songsy.service.SpotifyUrlService;

@Controller
public class IndexController {

	private final SpotifyUrlService spotifyUrlService;

	@Autowired
	public IndexController(SpotifyUrlService spotifyUrlService) {
		this.spotifyUrlService = spotifyUrlService;
	}

	@GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
	public String showIndex(final Model model) {
		model.addAttribute("url", spotifyUrlService.getAuthorizationURL());
		return Template.INDEX;
	}

}
