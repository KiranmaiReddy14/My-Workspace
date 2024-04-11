package com.mailorderpharma.webportal.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.mailorderpharma.webportal.entity.DrugDetails;
import com.mailorderpharma.webportal.entity.DrugLocationDetails;

public class DrugLocationDetailsTest {

	DrugLocationDetails loc = new DrugLocationDetails();
	DrugDetails drug = new DrugDetails();

	@Test
	public void testSerialId() {
		loc.setSerialId("s1");
		assertEquals("s1", loc.getSerialId());
	}

	@Test
	public void testLocation() {
		loc.setLocation("Chennai");
		assertEquals("Chennai", loc.getLocation());
	}

	@Test
	public void testQuantity() {
		loc.setQuantity(10);
		assertEquals(10, loc.getQuantity());
	}

	@Test
	public void testDrugDetails() throws Exception {
		String d = "12-12-2020";
		Date date = new SimpleDateFormat("dd-mm-yyyy").parse(d);
		d = "01-04-2022";
		Date date1 = new SimpleDateFormat("dd-mm-yyyy").parse(d);
		drug.setDrugId("drug1");
		drug.setDrugName("aspirin");
		drug.setManufacturer("Apollo");
		drug.setManufactureDate(date);
		drug.setExpiryDate(date1);
		drug.setMsg("3 times a day");

		assertEquals("drug1", drug.getDrugId());
		assertEquals("aspirin", drug.getDrugName());
		assertEquals("Apollo", drug.getManufacturer());
		assertEquals(date, drug.getManufactureDate());
		assertEquals(date1, drug.getExpiryDate());
		assertEquals("3 times a day", drug.getMsg());
	}
}
