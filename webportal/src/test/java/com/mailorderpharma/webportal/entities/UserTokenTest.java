package com.mailorderpharma.webportal.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.mailorderpharma.webportal.entity.UserToken;

public class UserTokenTest {

	UserToken token = new UserToken("token1", "authToken1");

	@Test
	public void testId() {
		assertEquals("token1", token.getUid());
	}

	@Test
	public void testAuthToken() {
		assertEquals("authToken1", token.getAuthToken());
	}
}
