package com.mailorderpharma.webportal.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.mailorderpharma.webportal.entity.UserData;

public class UserDataTest {

	UserData data = new UserData("id1", "pass1", "name1", "authToken");

	@Test
	public void testId() {
		assertEquals("id1", data.getUserid());
	}

	@Test
	public void testPassword() {
		assertEquals("pass1", data.getUpassword());
	}

	@Test
	public void testName() {
		assertEquals("name1", data.getUname());
	}

	@Test
	public void testAuthToken() {
		assertEquals("authToken", data.getAuthToken());
	}
}
