package com.user;

public class Person {
	
	private static String name;
	
	private static String lastName;
	
	private static String adress;
	
	private static String fathName;
	
	private static String bankAcc;
	
	public static String getName() {
		return name;
	}
	
	public static void setName(String name) {
		Person.name = name;
	}

	public static String getLastName() {
		return lastName;
	}

	public static void setLastName(String lastMame) {
		Person.lastName = lastMame;
	}

	public static String getAdress() {
		return adress;
	}

	public static void setAdress(String adress) {
		Person.adress = adress;
	}

	public static String getFathName() {
		return fathName;
	}

	public static void setFathName(String fathName) {
		Person.fathName = fathName;
	}

	public static String getBankAcc() {
		return bankAcc;
	}

	public static void setBankAcc(String bankAcc) {
		Person.bankAcc = bankAcc;
	}

}
