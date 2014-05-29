package com.jcc.demo.designmode.abstractfactory;

public class ProductFactoryB implements ProductFactoryInterface {

	@Override
	public ProductAInterface createProductA() {
		return new ProductA2();
	}

	@Override
	public ProductBInterface createProductB() {
		return new ProductB2();
	}
}
