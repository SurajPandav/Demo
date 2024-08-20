package com.test;
public class Validate {
	
	public String validateUser(String un, String pwd) {
		
		String user = null;
		
		if(un.equals("Deeps") && pwd.equals("pass")) {
			user = "Welcome " +un;
		}else {
			user = "Welcome Guest";
		}
		return user;
	}

	public static void main(String[] args) {
		Validate v= new Validate();
		System.out.println(v.validateUser("Deeps", "pass"));

	}

}