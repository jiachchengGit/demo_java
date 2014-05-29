package com.jcc.demo.designmode.abstractfactory;


public class ProductA1 implements ProductAInterface {

	@Override
	public void showMySelf() {
		System.out.println("Product:"+this.getClass().getName());
	}

}
