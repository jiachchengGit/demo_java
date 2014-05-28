package com.jcc.demo.threadlocal;

public class ThreadLocalNumber {
	private int num = 0;
	// 变量封装，确保线程中变量安全，相互隔离
	private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
		public Integer initialValue() {
			return 0;
		}
	};

	public int getThreadLocalNextNum() {
		seqNum.set(seqNum.get() + 1);
		return seqNum.get();
	}

	public int getCurrentNum() {
		return num++;
	}

	public static void main(String[] args) {
		ThreadLocalNumber sn = new ThreadLocalNumber();
		TestClient t1 = new TestClient(sn);
		TestClient t2 = new TestClient(sn);
		TestClient t3 = new TestClient(sn);

		t1.start();
		t2.start();
		t3.start();
	}
}

class TestClient extends Thread {
	private ThreadLocalNumber sn;
	public TestClient(ThreadLocalNumber sn) {
		this.sn = sn;
	}

	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println("thread[" + Thread.currentThread().getName() +
			"] sn[" + sn.getThreadLocalNextNum() + "]");
			
			System.out.println("thread[" + Thread.currentThread().getName() +
			"] num[" + sn.getCurrentNum() + "]");
		}
	}
}
