package com.jcc.demo.threadpool;

public class ThreadPoolMain {

	public static void main(String[] args) {		
		ThreadPoolSingleton tp = ThreadPoolSingleton.getInstance();
		for(int i = 0;i<1000;i++){
			TaskThreadSimple s = new TaskThreadSimple(i+"_name_");
			tp.addTask2Execute(s);
		}
	}
}
