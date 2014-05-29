package com.jcc.demo.designmode.builder;


public class BuilderA implements Builder {

	Product p = new Product();
	@Override
	public void buliderA() {
		// TODO Auto-generated method stub
		p.add("BuilderA-A");
	}

	@Override
	public void builderB() {
		p.add("BuilderA-B");
	}

	@Override
	public Product getProduct() {
		return p;
	}

}
