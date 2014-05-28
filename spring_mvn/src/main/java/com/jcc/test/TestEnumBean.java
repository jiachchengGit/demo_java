package com.jcc.test;

public class TestEnumBean {
   
	public enum gener{Man,Femal};
	
	private String name;
	private int age;
	private gener sex;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public gener getSex() {
		return sex;
	}
	public void setSex(gener sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "TestEnumBean [name=" + name + ", age=" + age + ", sex=" + sex
				+ "]";
	}
	
}
