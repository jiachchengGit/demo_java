package com.jcc.demo.designmode.abstractfactory;

public class ProductClient {
   private ProductAInterface pa;
   private ProductBInterface pb;
   public ProductClient(ProductFactoryInterface factory){
	   this.pa = factory.createProductA();
	   this.pb = factory.createProductB();
   }
   
   public void showProduct(){
	   pa.showMySelf();
	   pb.showMySelf();
   }
   public static void main(String[] args){
	   ProductClient client = new ProductClient(new ProductFactoryA());
	   client.showProduct();
   }
}
