package com.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ValidateTest {

	Validate val;
	@Before
	public void setUp() {
		System.out.println("Set up  before val");
		val = new Validate(); 
	}
	
	@Test
	public void testValidateUser() {
		System.out.println("From Validate user ");
		assertEquals("Welcome Deeps",val.validateUser("Deeps", "pass") );
	}
	@After
	public void tearDown() {
		System.out.println("Tear down after val");
		val=null;
	}
}