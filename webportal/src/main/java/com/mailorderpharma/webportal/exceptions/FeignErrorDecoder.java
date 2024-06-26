package com.mailorderpharma.webportal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FeignErrorDecoder implements ErrorDecoder {

	@Override
	public Exception decode(String methodKey, Response response) {

		switch (response.status()) {
		case 404: {
			return new ResponseStatusException(HttpStatus.valueOf(response.status()), "Content is not available");
		}
		case 204: {
			return new ResponseStatusException(HttpStatus.valueOf(response.status()), "Requested object is empty.");
		}
		default:
			return new Exception(response.reason());
		}
	}

}