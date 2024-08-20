package com.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AssertionsTest {

	@Test
	public void testAssertions() {
		
		String str1=new String("deeps");
		String str2=new String("deeps");
		
		String str3=null;
		
		String str4="deeps";
		String str5="deeps";
		
		int a=5;
		int b=6;
		
		String [] expectedArray= {"one","two","three"};
		String [] actualArray= {"one","two","three"};
		
		assertEquals(str1,str2);
		assertSame(str1,str2);
		assertSame(str4,str5);
		assertNotNull(str3);
		assertNull(str3);
//		
		assertTrue(a>b);
		assertFalse(a>b);
		
		//assertArrayEquals(expectedArray,actualArray);
	}
}
