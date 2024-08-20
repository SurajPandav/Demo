package com.test;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalculateTest {

	Calculate cal;
	
	@Rule
    public ExpectedException ex= ExpectedException.none();
	@BeforeClass
	public static void setUpClass() {
		System.out.println("From static setupclass()");
	}
	
	@Before
	public void setUp() {
		System.out.println("Set up  before");
		 cal = new Calculate();
	}
	
	@Test
	public void testAdd() {
		System.out.println("From add() ");
		assertEquals(24, cal.add(10,10,4));
	}
	
	@Test
	public void testMultiply() {
		System.out.println("From Multiply() ");
		assertEquals(3, cal.multiply(1,3));
	}
	@Test
	public void testDivideWithZero() {
		System.out.println("From Divide() ");
		ex.expect(ArithmeticException.class);
		cal.divide(5, 0);
	}
	
	
	@After
	public void tearDown() {
		System.out.println("Tear down after ");
		cal=null;
	}
	@AfterClass
	public static void tearDownClass() {
		System.out.println("From static teardownclass()");
	}
}