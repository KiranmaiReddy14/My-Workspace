package com.tweetapp.dto;

public class Like {

	private String tweetId;
	private String username;

	public Like() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Like(String tweetId, String username) {
		super();
		this.tweetId = tweetId;
		this.username = username;
	}

	public String getTweetId() {
		return tweetId;
	}

	public void setTweetId(String tweetId) {
		this.tweetId = tweetId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
