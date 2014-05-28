package com.jcc.test;

import com.jcc.test.TestEnumBean.gener;

public class EnumMain {

	public static void main(String[] args) {
		TestEnumBean bean = new TestEnumBean();
		bean.setSex(gener.Femal);
    System.out.println(bean.toString());
	}

}
