package com.mailorderpharma.webportal.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.mailorderpharma.webportal.entity.DateModel;
import com.mailorderpharma.webportal.entity.LocationModel;

public class DateModelTest  {

	DateModel model = new DateModel();
	
	@Test
	public void testDate() throws Exception{
		String d = "2020-12-12";
		Date date = new SimpleDateFormat("yyyy-mm-dd").parse(d);
		model.setDate(date);
		assertEquals(model.getDate(),date);
	}
	
}
