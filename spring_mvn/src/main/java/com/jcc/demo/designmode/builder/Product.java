package com.jcc.demo.designmode.builder;

import java.util.ArrayList;
import java.util.List;

public class Product {
  private List<String> list = new ArrayList<String>();
  public void add(String part){
	  list.add(part);
  }
  
  public void show(){
	  String result = "";
	  for(String s:list){
		  result = result+s+",";
	  }
	  System.out.println("Product:" +result.replace("/,$/",""));
  }
}
