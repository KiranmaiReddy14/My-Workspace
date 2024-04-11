package com.mailorderpharma.webportal.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.mailorderpharma.webportal.entity.DrugDetails;
import com.mailorderpharma.webportal.entity.DrugLocationDetails;

public class DrugDetailsTest {

	DrugDetails drug = new DrugDetails();
	DrugLocationDetails dld = new DrugLocationDetails();

	@Test
	public void testDrugId() {
		drug.setDrugId("drug1");
		assertEquals("drug1", drug.getDrugId());
	}

	@Test
	public void testDrugName() {
		drug.setDrugName("aspirin");
		assertEquals("aspirin", drug.getDrugName());
	}

	@Test
	public void testManufacture() {
		drug.setManufacturer("Apollo");
		assertEquals("Apollo", drug.getManufacturer());
	}

	@Test
	public void testManufacturerDate() throws Exception {
		String d = "12-12-2020";
		Date date = new SimpleDateFormat("dd-mm-yyyy").parse(d);
		drug.setManufactureDate(date);
		assertEquals(date, drug.getManufactureDate());
	}

	@Test
	public void testExpiryDate() throws Exception {
		String d = "01-04-2022";
		Date date = new SimpleDateFormat("dd-mm-yyyy").parse(d);
		drug.setExpiryDate(date);
		assertEquals(date, drug.getExpiryDate());
	}

	@Test
	public void testMessage() {
		drug.setMsg("3 times a day");
		assertEquals("3 times a day", drug.getMsg());
	}

	@Test
	public void testLocation() {
		List<DrugLocationDetails> list = new ArrayList<DrugLocationDetails>();
		dld.setSerialId("s1");
		dld.setQuantity(2);
		dld.setLocation("Chennai");
		dld.setDrugDetails(drug);
		list.add(dld);
		assertEquals("s1", list.get(0).getSerialId());
		assertEquals(2, list.get(0).getQuantity());
		assertEquals("Chennai", list.get(0).getLocation());
		assertEquals(drug, list.get(0).getDrugDetails());
	}
}
