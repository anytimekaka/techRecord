package com.techRecord.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {

	public static void main(String args[]) {
		final Semaphore semp = new Semaphore(5);
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int index = 0; index < 20; index++) {
			final int NO = index;
			Runnable run = new Runnable() {
				public void run() {
					try {
						// 获取许可
						semp.acquire();
						System.out.println("Accessing: " + NO);
						Thread.sleep((long) (Math.random() * 10000));
						// 访问完后，释放
						semp.release();
						System.out.println("-----------------" + semp.availablePermits());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			exec.execute(run);
		}
		exec.shutdown();
	}
}