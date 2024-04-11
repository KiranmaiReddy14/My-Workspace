package com.mailorderpharma.webportal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(feign.RetryableException.class)
	@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
	public Exception serviceUnavailableException() {
		//log.info(" in global exc handler RetryableException");
		return new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Temporarily service unavailable");
	}

}