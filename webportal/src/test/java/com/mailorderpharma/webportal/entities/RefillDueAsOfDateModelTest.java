package com.mailorderpharma.webportal.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.mailorderpharma.webportal.entity.RefillDueAsOfDateModel;

public class RefillDueAsOfDateModelTest {

	RefillDueAsOfDateModel model = new RefillDueAsOfDateModel();

	@Test
	public void testMemberId() {
		model.setMemberId("M1");
		assertEquals("M1", model.getMemberId());
	}

	@Test
	public void testDate() {
		model.setDate(12);
		assertEquals(12, model.getDate());
	}
}
