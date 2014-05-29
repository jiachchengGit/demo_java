package com.jcc.demo.designmode.abstractfactory;

public class ProductFactoryA implements ProductFactoryInterface {

	@Override
	public ProductAInterface createProductA() {
		return new ProductA1();
	}

	@Override
	public ProductBInterface createProductB() {
		return new ProductB1();
	}

}
