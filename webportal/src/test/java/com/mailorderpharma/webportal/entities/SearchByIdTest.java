package com.mailorderpharma.webportal.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.mailorderpharma.webportal.entity.SearchById;

public class SearchByIdTest {

	SearchById id = new SearchById();

	@Test
	public void testId() {
		id.setId("5");
		assertEquals("5", id.getId());
	}

	@Test
	public void testName() {
		id.setName("wen");
		assertEquals("wen", id.getName());
	}
}
