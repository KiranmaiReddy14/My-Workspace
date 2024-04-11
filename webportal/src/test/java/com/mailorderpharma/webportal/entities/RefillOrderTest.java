package com.mailorderpharma.webportal.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.mailorderpharma.webportal.entity.RefillOrder;

public class RefillOrderTest {

	RefillOrder order = new RefillOrder();
	RefillOrder order1;

	@Test
	public void testRefill() throws Exception {
		String d = "12-12-2020 04:00:00";
		Date date = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse(d);
		order1 = new RefillOrder(1,date,true,101,10,"s1");
		order.setId(1);
		assertEquals(1,order.getSub_id());
	}

	@Test
	public void testDate() throws Exception {
		String d = "12-12-2020 04:00:00";
		Date date1 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse(d);
		order.setRefilledDate(date1);
		assertEquals(order.getRefilledDate(), date1);
	}

	@Test
	public void tesPayStatus() {
		order.setPayStatus(true);
		assertEquals(order.getPayStatus(), true);
	}

	@Test
	public void testSubscriptionId() {
		order.setSub_id(10001);
		assertEquals(10001, order.getSub_id());
	}

	@Test
	public void testQuantity() {
		order.setQuantity(2);
		assertEquals(order.getQuantity(), 2);
	}

	@Test
	public void testMemberId() {
		order.setMemberId("m1");
		assertEquals(order.getMemberId(), "m1");
	}
}
