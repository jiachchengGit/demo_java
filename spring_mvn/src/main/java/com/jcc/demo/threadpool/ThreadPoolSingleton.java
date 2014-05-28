package com.jcc.demo.threadpool;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolSingleton {

	private ThreadPoolSingleton() {	}

	private static ThreadPoolExecutor executor = null;
	private static ThreadPoolSingleton singleton = null;
	
	/**
	 * @return
	 */
	public static ThreadPoolSingleton getInstance(){
		return getInstance(new PoolParameter());
	}
	
	/**
	 * @param pp
	 * @return
	 */
	public static ThreadPoolSingleton getInstance(PoolParameter pp) {
		if (singleton == null) {
			singleton = new ThreadPoolSingleton();
			executor = new ThreadPoolExecutor(pp.getCorePoolSize(),
					pp.getMaximumPoolSize(), pp.getKeepAliveTime(),
					TimeUnit.SECONDS, pp.getWorkQueue(),
					new ThreadPoolExecutor.DiscardOldestPolicy());
		}
		return singleton;
	}

	/**
	 * @param run
	 */
	public void addTask2Execute(Runnable run) {
		int size = 0;
		while((size = executor.getQueue().size()) > (executor.getMaximumPoolSize() * 5)){
			try {
				System.out.println("线程负荷过重["+size+"]，等待1秒后重试....");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
			}
		}
		executor.execute(run);
	}
}
