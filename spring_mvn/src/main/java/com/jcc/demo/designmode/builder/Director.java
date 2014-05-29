package com.jcc.demo.designmode.builder;

public class Director {
	
	public void construct(Builder b){
		b.builderB();
		b.buliderA();
	}
	
	public static void main(String[] args){
		Builder b = new BuilderA();
		Builder b2 = new BuilderB();
		Director d = new Director();
		d.construct(b);
		Product p1 = b.getProduct();
		p1.show();
		d.construct(b2);
		Product p = b2.getProduct();
		p.show();
	}
}
