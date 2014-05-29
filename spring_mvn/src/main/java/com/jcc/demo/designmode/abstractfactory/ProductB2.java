package com.jcc.demo.designmode.abstractfactory;


public class ProductB2 implements ProductBInterface {

	@Override
	public void showMySelf() {
		System.out.println("Product:"+this.getClass().getName());
	}

}
