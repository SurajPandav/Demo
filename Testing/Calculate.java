package com.test;

public class Calculate {

	public int add(int... number) {
		int result =0;
		
		for(int i :number) {
			result = result+i;
		}
		
		return result;
	}
	
	public int multiply(int... number) {
		int result =1;
		
		for(int i :number) {
			result = result*i;
		}
		
		return result;
	}
	
	public int divide(int a, int b) {
		int result=0;
		result = a/b;
		
		return result;
	}
	public static void main(String[] args) {
		Calculate c = new Calculate();
		System.out.println(c.add(1,2));
		System.out.println(c.add(1,2,3));
		System.out.println(c.add(1,2,3,4));
		
		System.out.println(c.multiply(1,2));
		//System.out.println(c.divide(2, 0));

	}

}