package com.jcc.demo.enums;

public enum EnumTwo {
  
	ONE("EnumTwo-ONE"),
	TWO("EnumTwo-TWO"),
	THREE("EnumTwo-THREE");
	
	private String value;
	private EnumTwo(String value){
		this.value = value;
	}
	public String getValue() {
		return value;
	}
}
