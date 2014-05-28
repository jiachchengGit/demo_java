package com.jcc.demo.threadpool;

public class TaskThreadSimple implements Runnable {
	private String name = null;

	public TaskThreadSimple(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		try {
			System.out.println("[我是" + name + "],先休息1秒......");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		System.out.println("[我是" + name + "],执行任务......");
	}
}
