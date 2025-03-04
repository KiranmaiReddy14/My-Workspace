package com.kiran.songsy.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kiran.songsy.constant.ApiPath;
import com.kiran.songsy.constant.Template;

@Controller
public class CustomErrorNotFoundController implements ErrorController {

	@RequestMapping(value = ApiPath.ERROR, produces = MediaType.TEXT_HTML_VALUE)
	public String handleError() {
		return Template.ERROR;
	}

}