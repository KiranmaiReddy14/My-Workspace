package com.kiran.songsy.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kiran.songsy.constant.ApiPath;
import com.kiran.songsy.constant.Template;
import com.kiran.songsy.exception.InvalidSearchException;
import com.kiran.songsy.service.SearchResultService;

@Controller
public class ItemSearchController {

	private final SearchResultService searchResults;

	@Autowired
	public ItemSearchController(SearchResultService searchResults) {
		this.searchResults = searchResults;
	}

	@PostMapping(value = ApiPath.SEARCH, produces = MediaType.TEXT_HTML_VALUE)
	public String showSearchResults(@RequestParam("searchQuery") final String searchQuery, final HttpSession session,
			final Model model) {
		String token = (String) session.getAttribute("accessToken");
		try {
			model.addAttribute("results", searchResults.search(token, searchQuery));
		} catch (InvalidSearchException exception) {
			return Template.SEARCH_ERROR;
		}
		return Template.SEARCH_RESULTS;
	}

}
