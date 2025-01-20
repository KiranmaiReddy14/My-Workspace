package com.tweetapp.exception;

public class TweetDoesNotExistException extends Exception {
	
	public TweetDoesNotExistException(String msg) {
		super(msg);
	}
}
