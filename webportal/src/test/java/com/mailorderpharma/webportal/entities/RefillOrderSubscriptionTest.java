package com.mailorderpharma.webportal.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.mailorderpharma.webportal.entity.RefillOrderSubscription;

public class RefillOrderSubscriptionTest {

	RefillOrderSubscription refill = new RefillOrderSubscription();
	RefillOrderSubscription refill1 = new RefillOrderSubscription(1, 1001, "m1", 2, 2);

	@Test
	public void testId() {
		refill.setId(1);
		assertEquals(1, refill.getId());
	}

	@Test
	public void testSubscriptionId() {
		refill.setSubscriptionId(101);
		assertEquals(101, refill.getSubscriptionId());
	}

	@Test
	public void testMemberId() {
		refill.setMemberId("m1");
		assertEquals("m1", refill.getMemberId());
	}

	@Test
	public void testRefillQuantity() {
		refill.setRefillQuantity(2);
		assertEquals(2, refill.getRefillQuantity());
	}

	@Test
	public void testRefillTime() {
		refill.setRefillTime(2);
		assertEquals(2, refill.getRefillTime());
	}
}
