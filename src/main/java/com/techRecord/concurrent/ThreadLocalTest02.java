package com.techRecord.concurrent;

public class ThreadLocalTest02 {

	public static Apple apple = new Apple();	//线程共享
	public static ThreadLocal<Integer> local = new ThreadLocal<Integer>();	//线程独立
	static {
		ThreadLocalTest02.local.set(1);
	}

	public static void main(String args[]) throws InterruptedException {
		Thread thread1 = new Thread(new ThreadTest());
		Thread thread2 = new Thread(new ThreadTest());
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
	}

}

class ThreadTest implements Runnable {

	@SuppressWarnings("static-access")
	public void run() {
		ThreadLocalTest02.apple.setNum((int) (Math.random() * 100D));
		ThreadLocalTest02.local.set((int) (Math.random() * 100D));
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(ThreadLocalTest02.apple.getNum());
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(ThreadLocalTest02.local.get());
	}

}

class Apple {
	private Integer num;

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
}