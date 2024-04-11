package com.mailorderpharma.webportal.entities;

import org.junit.jupiter.api.Test;

import com.mailorderpharma.webportal.entity.AuthResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AuthResponseTest {

	AuthResponse auth=new AuthResponse("id1","name1",true);
	
	@Test
	public void testUser() {
		assertEquals(auth.getUid(),"id1");
		assertEquals(auth.getName(),"name1");
		assertEquals(auth.isValid(),true);
		assertNotEquals(auth.getUid(),"id2");
		assertNotEquals(auth.getName(),"name");
		assertNotEquals(auth.isValid(),false);
	}
	
	
}
