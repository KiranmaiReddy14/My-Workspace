package com.mailorderpharma.webportal.entities;

import org.junit.jupiter.api.Test;

import com.mailorderpharma.webportal.entity.AdHocModel;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AdhocTest {

	AdHocModel ad = new AdHocModel();
	AdHocModel ad1=new AdHocModel(10,"Chennai",true);
	
	@Test
	public void testQuantity() {

		assertTrue(ad.getQuantity() < 15);
		assertFalse(ad.getQuantity() > 3);
	}
	
	@Test
	public void testLocation() {
		ad.setLocation("Chennai");
		assertEquals(ad.getLocation(),"Chennai");
		assertNotEquals(ad.getLocation(), "China");
	}

}
