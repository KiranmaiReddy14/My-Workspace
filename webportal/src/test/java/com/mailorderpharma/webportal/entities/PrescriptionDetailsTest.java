package com.mailorderpharma.webportal.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.mailorderpharma.webportal.entity.PrescriptionDetails;

public class PrescriptionDetailsTest {

	PrescriptionDetails pres = new PrescriptionDetails();

	@Test
	public void testPrescriptionId() {
		long id = 101;
		pres.setPrescriptionId(id);
		assertEquals(101, pres.getPrescriptionId());
	}

	@Test
	public void testMemberId() {
		pres.setMemberId("Mem1");
		assertEquals("Mem1", pres.getMemberId());
	}

	@Test
	public void testMemberLocation() {
		pres.setMemberLocation("Pune");
		assertEquals("Pune", pres.getMemberLocation());
	}

	@Test
	public void testPolicyNumber() {
		pres.setPolicyNumber("Pol111");
		assertEquals("Pol111", pres.getPolicyNumber());
	}

	@Test
	public void testInsuranceProvider() {
		pres.setInsuranceProvider("LIC");
		assertEquals("LIC", pres.getInsuranceProvider());
	}

	@Test
	public void testPrescriptionDate() {
		LocalDate date = LocalDate.now();
		pres.setPrescriptionDate(date);
		assertEquals(date, pres.getPrescriptionDate());
	}

	@Test
	public void testDrugName() {
		pres.setDrugName("Aspirin");
		assertEquals("Aspirin", pres.getDrugName());
	}

	@Test
	public void testDosageDefinition() {
		pres.setDosageDefinition("3 / day");
		assertEquals("3 / day", pres.getDosageDefinition());
	}

	@Test
	public void testQuantity() {
		pres.setQuantity(2);
		assertEquals(2, pres.getQuantity());
	}

	@Test
	public void testCourseDuration() {
		pres.setCourseDuration(4);
		assertEquals(4, pres.getCourseDuration());
	}

	@Test
	public void testDoctorName() {
		pres.setDoctorName("Dr.Wen");
		assertEquals("Dr.Wen", pres.getDoctorName());
	}
}
