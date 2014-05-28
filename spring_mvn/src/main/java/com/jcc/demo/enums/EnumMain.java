package com.jcc.demo.enums;

public class EnumMain {

	public static void main(String[] args) {
		for (EnumOne o : EnumOne.values()) {
			System.out.println("EnumOne---" + o.toString());
		}
		
		System.out.println("-------------------------------------------");
		for (EnumTwo o : EnumTwo.values()) {
			System.out.println("EnumTwo---" + o.toString());
			System.out.println("EnumTwo---" + o.getValue());
			System.out.println();
		}
		System.out.println("-------------------------------------------");
		for (EnumThree o : EnumThree.values()) {
			System.out.println("EnumThree---" + o.toString());
			System.out.println("EnumThree---" + o.getV());
			System.out.println();
		}
		System.out.println("-------------------------------------------");
	}
	
}
