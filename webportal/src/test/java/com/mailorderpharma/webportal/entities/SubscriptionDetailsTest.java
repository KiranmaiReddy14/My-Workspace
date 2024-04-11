package com.mailorderpharma.webportal.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.mailorderpharma.webportal.entity.SubscriptionDetails;

public class SubscriptionDetailsTest {

	SubscriptionDetails sd = new SubscriptionDetails();

	@Test
	public void testsubscriptionId() throws Exception {
		long id = 101;
		sd.setSubscriptionId(id);
		assertEquals(id, sd.getSubscriptionId());
	}

	@Test
	public void testPrescriptionId() {
		long id = 100001;
		sd.setPrescriptionId(id);
		assertEquals(id, sd.getPrescriptionId());
	}

	@Test
	public void testRefillCycle() {
		sd.setRefillCycle(1);
		assertEquals(1, sd.getRefillCycle());
	}

	@Test
	public void testQuantity() {
		sd.setQuantity(2);
		assertEquals(2, sd.getQuantity());
	}

	@Test
	public void testLocation() {
		sd.setMemberLocation("m1");
		assertEquals("m1", sd.getMemberLocation());
	}

	@Test
	public void testSubscriptionDate() {
		LocalDate date = LocalDate.now();
		sd.setSubscriptionDate(date);
		assertEquals(date, sd.getSubscriptionDate());
	}

	@Test
	public void testMemberLocation() {
		sd.setMemberLocation("Chennai");
		assertEquals("Chennai", sd.getMemberLocation());
	}

	@Test
	public void testStatus() {
		sd.setSubscriptionStatus("Subscribed");
		assertEquals("Subscribed", sd.getSubscriptionStatus());
	}

	@Test
	public void testDrugName() {
		sd.setDrugName("Aspirin");
		assertEquals("Aspirin", sd.getDrugName());
	}

}
