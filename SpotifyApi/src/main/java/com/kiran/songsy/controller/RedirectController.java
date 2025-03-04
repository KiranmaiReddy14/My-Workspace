package com.kiran.songsy.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kiran.songsy.constant.ApiPath;
import com.kiran.songsy.constant.Template;
import com.kiran.songsy.exception.NoTrackPlayingException;
import com.kiran.songsy.service.CurrentPlayingService;
import com.kiran.songsy.service.ProfileDetailService;

@Controller
public class RedirectController {

	private final ProfileDetailService userDetails;
	private final CurrentPlayingService currentPlaying;

	@Autowired
	public RedirectController(ProfileDetailService userDetails, CurrentPlayingService currentPlaying) {
		this.userDetails = userDetails;
		this.currentPlaying = currentPlaying;
	}

	@GetMapping(value = ApiPath.REDIRECT, produces = MediaType.TEXT_HTML_VALUE)
	public String redirectToCallbackSuccess(final HttpSession session, final Model model) {

		String token = (String) session.getAttribute("accessToken");
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
