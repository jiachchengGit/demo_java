package com.jcc.demo.designmode.builder;


public class BuilderB implements Builder {

	Product p = new Product();
	@Override
	public void buliderA() {
		// TODO Auto-generated method stub
		p.add("BuilderB-A");
	}

	@Override
	public void builderB() {
		p.add("BuilderB-B");
	}

	@Override
	public Product getProduct() {
		return p;
	}

}
