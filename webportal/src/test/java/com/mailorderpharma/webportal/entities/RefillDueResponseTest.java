package com.mailorderpharma.webportal.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.mailorderpharma.webportal.entity.RefillDueResponse;

public class RefillDueResponseTest {

	RefillDueResponse due = new RefillDueResponse();

	LocalDate date = LocalDate.now();
	RefillDueResponse due1 = new RefillDueResponse("Cold Act", 101, 1, "m1", 12, 4, date);

	@Test
	public void testDrugName() {
		due.setDrugName("Cold Act");
		assertEquals("Cold Act", due.getDrugName());
	}

	@Test
	public void testId() {
		long id = 101;
		due.setId(id);
		assertEquals(101, due.getId());
	}

	@Test
	public void testSubscriptionID() {
		long id = 1;
		due.setSubscriptionId(id);
		assertEquals(1, due.getSubscriptionId());
	}

	@Test
	public void testMemberId() {
		due.setMemberId("m1");
		assertEquals("m1", due.getMemberId());
	}

	@Test
	public void testRefillQuantity() {
		due.setRefillQuantity(3);
		assertEquals(3, due.getRefillQuantity());
	}

	@Test
	public void testRefillTime() {
		due.setRefillTime(1);
		assertEquals(1, due.getRefillTime());
	}

	@Test
	public void testDate() {
		LocalDate date = LocalDate.now();
		due.setDate(date);
		assertEquals(date, due.getDate());
	}
}
