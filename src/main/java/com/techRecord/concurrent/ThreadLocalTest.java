package com.techRecord.concurrent;

public class ThreadLocalTest {

	public static class MyRunnable implements Runnable {
		private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

		public static class Apple {
			private Integer count;

			public Integer getCount() {
				return count;
			}

			public void setCount(Integer count) {
				this.count = count;
			}
		}

		private Apple apple = new Apple();

		public void run() {
			apple.setCount((int) (Math.random() * 100D));
			threadLocal.set((int) (Math.random() * 100D));
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}

			System.out.println(Thread.currentThread().toString() + ":"
					+ threadLocal.get());
			System.out.println(Thread.currentThread().toString() + ":"
					+ apple.getCount());
		}
	}

	public static void main(String[] args) throws InterruptedException {
		MyRunnable sharedRunnableInstance = new MyRunnable();
		Thread thread1 = new Thread(sharedRunnableInstance);
		Thread thread2 = new Thread(sharedRunnableInstance);
		thread1.start();
		thread2.start();
		thread1.join(); // wait for thread 1 to terminate
		thread2.join(); // wait for thread 2 to terminate
	}
}
